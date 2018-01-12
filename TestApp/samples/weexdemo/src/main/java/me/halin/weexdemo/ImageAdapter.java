package me.halin.weexdemo;

import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by halin on 10/14/17.
 */

public class ImageAdapter implements IWXImgLoaderAdapter {
    @Override
    public void setImage(final String urlString, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {

    }
}
