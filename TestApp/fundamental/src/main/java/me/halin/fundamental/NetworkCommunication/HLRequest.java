package me.halin.fundamental.NetworkCommunication;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.Map;

/**
 * @Title: yqtrack.app.Fundamental.NetworkCommunication
 * @Copyright: © Copyright 2010-2015 17track Rights Reserved
 * @Description: ${todo}<请描述此文件是做什么的>
 * @author: YAOZHONGWU
 * @data: 2015/7/29 14:21
 * @version: V1.0
 */
public abstract class HLRequest<T> extends Request<T> {


    private Map<String, String> responseHeader;
    /**
     * 超时时间
     */
    private static final int RETRY_TIME = 30 * 1000;

    //region 网络耗时计数
    /**
     * 启动事件
     */
    private long networkStartTime;

    /**
     * 结束事件
     */
    private long networkFinishTime;


    /**
     * 获得结束时间
     */
    public long getNetworkFinishTime() {
        return networkFinishTime;
    }

    /**
     * 获得启动时间
     */
    public long getNetworkStartTime() {
        return networkStartTime;
    }

    /**
     * 获得网络耗时,请求未完成返回-1
     */
    public long getNetworkTimeConsuming() {
        if (networkStartTime == 0 || networkFinishTime == 0) {
            return -1;
        } else {
            return networkFinishTime - networkStartTime;
        }
    }


    @Override
    public void addMarker(String tag) {
        super.addMarker(tag);
        switch (tag) {

            case "network-queue-take":
                networkStartTime = System.currentTimeMillis();

                break;
            case "network-http-complete":
                networkFinishTime = System.currentTimeMillis();
                break;
        }
    }

//endregion

    public HLRequest(String url, Response.ErrorListener listener) {
        super(url, listener);
    }

    public HLRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
        //默认重试一次,避免跳转报错
        this.setRetryPolicy(new DefaultRetryPolicy(RETRY_TIME, 1, 0));
        this.setShouldCache(false);
    }


    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {

        responseHeader = response.headers;


        return null;
    }


    public Map<String, String> getResponseHeader() {
        return responseHeader;
    }

}
