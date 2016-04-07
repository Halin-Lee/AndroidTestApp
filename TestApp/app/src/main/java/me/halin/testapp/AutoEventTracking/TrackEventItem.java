package me.halin.testapp.AutoEventTracking;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by 17track on 4/5/16.
 */
public class TrackEventItem {

    public static final int TYPE_FLING = 0x01;
    public static final int TYPE_SCROLL = 0x02;
    public static final int TYPE_TAP = 0x04;
    public static final int TYPE_LONG_PRESS = 0x08;


    /**
     * 是否忽略
     */
    private boolean ignored = false;

    /**
     * 跟踪类型(点击,滑动,长按之类的)
     */
    private int type;

    /**
     * 跟踪的view id
     */
    private int id;

    /**
     * 事件名称
     */
    private String name;

    /**
     * 父view id
     */
    private int parent;


    private String tag = "";

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public boolean isIgnored() {
        return ignored;
    }

    public void setIgnored(boolean ignored) {
        this.ignored = ignored;
    }

    @NonNull
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
