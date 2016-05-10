package me.halin.testapp.RequestSimulator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.fundamental.NetworkCommunication.HLStringRequest;
import me.halin.fundamental.NetworkCommunication.RedirectHandleHurlStack;
import me.halin.fundamental.NetworkCommunication.TrustAnyCertificateHurlStack;
import me.halin.testapp.R;
import me.halin.testapp.RequestSimulatorBinding;


/**
 * Created by Halin on 5/10/16.
 */
public class RequestSimulatorActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {

    public static final String TAG = RequestSimulatorActivity.class.getName();

    //region 默认参数
    /**
     * 默认URL
     */
    public static final String DEFAULT_URL = "https://userapi.17track.net/api/user/setcookie";
    /**
     * 默认方法
     */
    public static final int DEFAULT_METHOD = Request.Method.POST;
    /**
     * 默认是否信任证书
     */
    public static final boolean DEFAULT_TRUST_ANY_CERTIFICATE = true;

    //endregion

    private RequestSimulatorBinding requestSimulatorBinding;

    /**
     * 正常请求队列
     */
    private RequestQueue normalRequestQueue;

    /**
     * 信任全部队列
     */
    private RequestQueue trustAnyRequestQueue;

    /**
     * 文本请求
     */
    private HLStringRequest stringRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestSimulatorBinding = DataBindingUtil.setContentView(this, R.layout.activity_reqeust_simulator);
        requestSimulatorBinding.setUrl(DEFAULT_URL);
        requestSimulatorBinding.setMethod(DEFAULT_METHOD);
        requestSimulatorBinding.setTrustAnyCertificate(DEFAULT_TRUST_ANY_CERTIFICATE);


        //设置默认的cookie管理器
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        //自行处理重定向
        HttpURLConnection.setFollowRedirects(false);

        normalRequestQueue = Volley.newRequestQueue(this, new RedirectHandleHurlStack());
        trustAnyRequestQueue = Volley.newRequestQueue(this, TrustAnyCertificateHurlStack.getInstance());
    }


    public void methodClick(View view) {
        if (view.getId() == R.id.get_check_box) {
            requestSimulatorBinding.setMethod(Request.Method.GET);
        } else {
            requestSimulatorBinding.setMethod(Request.Method.POST);
        }
    }

    public void submit(View view) {

        if (stringRequest != null) {
            Logger.debug("重复请求");
            Toast.makeText(RequestSimulatorActivity.this, "重复请求", Toast.LENGTH_SHORT).show();
            return;
        }

        stringRequest = new HLStringRequest(requestSimulatorBinding.getMethod(), requestSimulatorBinding.getUrl(), this, this) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                String param = requestSimulatorBinding.getParam();
                if (param == null) {
                    return null;
                }

                try {
                    return requestSimulatorBinding.getParam().getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    Logger.logE(TAG, "文本解析失败");
                    return null;
                }
            }
        };
        if (requestSimulatorBinding.getTrustAnyCertificate()) {
            trustAnyRequestQueue.add(stringRequest);
        } else {
            normalRequestQueue.add(stringRequest);
        }
        Logger.debug("请求提交");
        Toast.makeText(RequestSimulatorActivity.this, "请求提交", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        requestSimulatorBinding.setResult("请求失败 error:" + error);
        stringRequest = null;
    }

    @Override
    public void onResponse(String response) {
        requestSimulatorBinding.setResult("请求成功 Header:" + stringRequest.getResponseHeader() + ",result:" + response);
        stringRequest = null;
    }
}
