package me.halin.fundamental.NetworkCommunication;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HurlStack;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.SSLSocketFactory;

/**
 * 重定向处理HurlStack,处理所有的跳转
 * <p>
 * Android 4.1及以下版本..HTTPUrlConnection并不处理307跳转,导致正常模块出问题,此类处理这个问题
 * <p>
 * Created by halin on 12/25/15.
 */
public class RedirectHandleHurlStack extends HurlStack {
    /**
     * 最大重定向次数
     */
    private static final int MAX_REDIRECT_COUNT = 5;

    public RedirectHandleHurlStack() {
        super();
    }

    public RedirectHandleHurlStack(UrlRewriter urlRewriter) {
        super(urlRewriter);
    }

    public RedirectHandleHurlStack(UrlRewriter urlRewriter, SSLSocketFactory sslSocketFactory) {
        super(urlRewriter, sslSocketFactory);
    }

    @Override
    public org.apache.http.HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {

        //重定向次数
        int redirectCount = 0;

        while (true) {

            HttpResponse httpResponse;
            //请求
            try {
                httpResponse = super.performRequest(request, additionalHeaders);
            } catch (IncompatibleClassChangeError e) {
                //抛出java.lang.IncompatibleClassChangeError: libcore/io/StructAddrinfo,无法找到解决办法
                throw new IOException("performRequest 失败", e);

            }

            //处理所有跳转
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode >= 300 && statusCode < 400) {

                if (redirectCount > MAX_REDIRECT_COUNT) {
                    throw new AuthFailureError("过多重定向");
                }

                redirectCount++;

                //重定向,自行处理并重新请求
                Header[] redirectHeader = httpResponse.getHeaders("Location");
                String newUrlStr = redirectHeader[0].getValue();


                try {
                    //验证新url是否可用
                    new URL(newUrlStr);
                } catch (MalformedURLException e) {
                    //处理不带scheme和host的跳转
                    URL originUrl = new URL(request.getOriginUrl());
                    URL newUrl = new URL(originUrl.getProtocol(), originUrl.getHost(), originUrl.getPort(), newUrlStr);
                    newUrlStr = newUrl.toString();
                }
                request.setRedirectUrl(newUrlStr);
                continue;
            }

            //返回结果
            return httpResponse;

        }
    }


}
