package me.halin.fundamental.NetworkCommunication;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;

import me.halin.fundamental.LogUtil.Logger;


/**
 * 请求管理工具
 * <p/>
 * Created by Halin on 5/10/16.
 */
public class VolleyController {
    /**
     * 单例懒加载模式
     */
    private static final VolleyController mInstance = new VolleyController();
    /**
     * Log or request TAG
     * 用于日志或者请求的TAG
     */
    public static final String TAG = "VolleyPatterns";

    /**
     * Global request queue for Volley
     * volley的全局请求队列
     */
    private RequestQueue mRequestQueue;

    /**
     * @return ApplicationController singleton instance
     * 返回线程安全的单体对象
     */
    public static synchronized VolleyController getInstance() {
        return mInstance;
    }

    private VolleyController() {

    }

    public void setup(Context application) {

        //设置默认的cookie管理器
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        //自行处理重定向
        HttpURLConnection.setFollowRedirects(false);

        //初始化Volley队列
        if (Logger.isDebug()) {
            mRequestQueue = Volley.newRequestQueue(application, TrustAnyCertificateHurlStack.getInstance());
        } else {
            mRequestQueue = Volley.newRequestQueue(application, new RedirectHandleHurlStack());
        }
    }

    /**
     * @return 获取volley的请求队列，队列将会被创建假如他不存在
     */
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    /**
     * Adds the specified request to the global queue, if tag is specified then
     * it is used else Default TAG is used.
     * 添加一个指定的请求加入到全局队列中，该方法使用指定的TAG
     *
     * @param req
     * @param tag
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    /**
     * 添加一个指定的请求加入到全局队列中，该方法使用默认的TAG
     * Adds the specified request to the global queue using the Default TAG.
     *
     * @param req
     */
    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        req.setTag(TAG);

        getRequestQueue().add(req);
    }

    /**
     * Cancels all pending requests by the specified TAG, it is important to
     * specify a TAG so that the pending/ongoing requests can be cancelled.
     * 取消所有指定的TAG的请求。该方法必须指定TAG且TAG有效才能发挥作用
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
        VolleyLog.d("Cancel request as tag: %s", tag.toString());
    }


    public static boolean isInternetReachable() {
        try {
            URL url = new URL("http://www.17track.net");

            //open a connection to that source
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            //trying to retrieve data from the source. If there
            //is no connection, this line will fail
            Object objData = urlConnect.getContent();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
