package me.halin.fundamental.NetworkCommunication;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import me.halin.fundamental.LogUtil.Logger;


/**
 * 信任所有的HurlStack,用于服务器证书未升级导致无法使用HTTPS连接,仅限测试用,注意检查
 * <p/>
 * Created by Halin on 5/10/16.
 */
public class TrustAnyCertificateHurlStack extends RedirectHandleHurlStack {

    public static final String TAG = TrustAllTrustManager.class.getName();

    public static TrustAnyCertificateHurlStack getInstance() {
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllTrustManager()}, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            Logger.logE(TAG, "SSL加载失败,Error:%s", e);
        }
        return new TrustAnyCertificateHurlStack(null, sc != null ? sc.getSocketFactory() : null);

    }

    public TrustAnyCertificateHurlStack(UrlRewriter urlRewriter, SSLSocketFactory sslSocketFactory) {
        super(urlRewriter, sslSocketFactory);
    }

    private static class TrustAllTrustManager implements X509TrustManager {


        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }


    }

}
