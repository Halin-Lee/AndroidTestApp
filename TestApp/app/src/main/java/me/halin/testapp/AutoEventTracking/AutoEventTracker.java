package me.halin.testapp.AutoEventTracking;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.halin.fundamental.LogUtil.Logger;

/**
 *
 * 事件跟踪工具
 *
 * Created by 17track on 3/25/16.
 */
public class AutoEventTracker implements GestureDetector.OnGestureListener {
    public static final String TAG = AutoEventTracker.class.getName();


    private EventTrackerCallback callback = new EventTrackerCallback() {
        @Override
        public void callback(String page, String prefixString, TrackEventItem item, String name) {
            Logger.debug("页面:%s %s 事件:%s", pageName, prefixString, name);
        }
    };

    /**
     * 当前页面名称
     */
    private String pageName = "";

    /**
     * 页面名称前缀
     */
    private String prefixString = "";

    /**
     * 手势分析
     */
    private GestureDetector gestureDetector;

    /**
     * window的底层view
     */
    private View rootView;

    /***/
    private View viewOnTouchDown;

    /**
     * 滚动触发表示为,滚动事件会多次触发,为避免一次滚动多次触发,增加这个标志位
     */
    private boolean isScrollHappen;

    /**
     * 事件解析表,<对应的view ID,Set<事件>>
     */
    private Map<Integer, Set<TrackEventItem>> itemMap = new HashMap<>();

    private List<TrackEventItem> itemList;

    public AutoEventTracker(Activity activity) {
        this(activity, null);
    }

    public AutoEventTracker(Activity activity, EventTrackerCallback callback) {
        gestureDetector = new GestureDetector(activity, this);
        rootView = activity.getWindow().getDecorView().getRootView();
        AutoEventTrackerXMLLoader loader = AutoEventTrackerXMLLoader.getInstance();
        String className = activity.getClass().getName();
        pageName = loader.getPageName(className);
        itemList = loader.getItemForActivity(className);
        for (TrackEventItem item : itemList) {

            int id = item.getId();
            Set<TrackEventItem> items = itemMap.get(id);
            if (items == null) {
                items = new HashSet<>();
                itemMap.put(id, items);
            }
            items.add(item);

        }

        if (callback != null) {
            this.callback = callback;
        }
    }


    /**
     * 事件分发,在activity的dispatchTouchEvent调用这个方法
     */
    public void dispatchTouchEvent(MotionEvent event) {


        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //每次有点击事件,更换当前选中的view,还原标志位
            viewOnTouchDown = viewFromTouch(rootView, event);
            isScrollHappen = false;
        }

        gestureDetector.onTouchEvent(event);

    }

    /**
     * 根据MotionEvent寻找哪个view被点击
     */
    private View viewFromTouch(View view, MotionEvent event) {

        if (isViewContains(view, event)) {
            //点击在view内部
            if (view instanceof ViewGroup) {
                //是viewGroup,遍历
                int count = ((ViewGroup) view).getChildCount();
                for (int index = 0; index < count; index++) {
                    View subView = ((ViewGroup) view).getChildAt(index);
                    subView = viewFromTouch(subView, event);
                    if (subView != null)
                        return subView;
                }
                //没有子view被点击,返回自己
                return view;
            } else {
                //不是viewGroup,返回自己
                return view;
            }
        } else {
            return null;
        }
    }

    /**
     * 判断MotionEvent是否在view内部
     */
    private boolean isViewContains(View view, MotionEvent event) {
        int rx = (int) event.getRawX();
        int ry = (int) event.getRawY();
        int[] location = new int[2];
        view.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        int w = view.getWidth();
        int h = view.getHeight();


        if (rx < x || rx > x + w || ry < y || ry > y + h) {
            return false;
        }
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        String toastString = String.format("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        String toastString = String.format("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        uploadEvent(viewOnTouchDown, TrackEventItem.TYPE_TAP);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        

        //TODO:onScroll做得还不够好,1.没有滑动方向,2.滑动没结束就上报了
        if (!isScrollHappen) {
            uploadEvent(viewOnTouchDown, TrackEventItem.TYPE_SCROLL);
            isScrollHappen = true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        uploadEvent(viewOnTouchDown, TrackEventItem.TYPE_LONG_PRESS);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        uploadEvent(viewOnTouchDown, TrackEventItem.TYPE_FLING);

        return false;
    }


    /**
     * 上传事件
     */
    private void uploadEvent(View v, int eventType) {

        int id = v.getId();
        Set<TrackEventItem> items = itemMap.get(id);
        if (items != null) {
            for (TrackEventItem item : items) {
                if (item.getType() == eventType) {
                    //找到对应item,且事件类型相同

                    if (item.isIgnored()) {
                        //忽略的项,不作处理
                        return;
                    }

                    int parent = item.getParent();
                    if (parent == 0 || isContainsParentWithID(v, parent)) {
                        //没有指定的parent或者,view包含有指定的parent,匹配完成,上报
                        callback.callback(pageName, prefixString, item, item.getName());
                        return;
                    }
                }
            }
        }
        //当前view不在列表,找下一个view
        ViewParent parent = v.getParent();
        if (parent != null && parent instanceof View && ((View) parent).getId() != android.R.id.content) {
            //有父类,往父类找
            uploadEvent((View) parent, eventType);
        } else {
            //没有父类了,当前事件没有响应者,找出有没有view的id

            id = lastParentViewId(viewOnTouchDown);
            if (id != -1) {
                //找到父类有id,上报,以后或许有帮助
                String name = "type:" + String.valueOf(eventType) + ",id:" + String.valueOf(id);
                callback.callback(pageName, prefixString, null, name);
            }
            return;
        }

    }


    /**
     * 寻找父类的id
     */
    private int lastParentViewId(View v) {

        //id不同,向父类寻找
        ViewParent parent = v.getParent();
        if (parent != null && parent instanceof View && ((View) parent).getId() != android.R.id.content) {
            View parentView = (View) parent;
            int viewId = parentView.getId();
            if (viewId != -1) {
                return viewId;
            } else {
                return lastParentViewId(parentView);
            }
        } else {
            return -1;
        }

    }

    /**
     * 寻找父类,确定是否包含id
     */
    private boolean isContainsParentWithID(View v, int id) {
        int viewId = v.getId();

        if (viewId == id) {
            //id相同,返回true
            return true;
        } else {
            //id不同,向父类寻找
            ViewParent parent = v.getParent();
            if (parent != null && parent instanceof View && ((View) parent).getId() != android.R.id.content) {
                return isContainsParentWithID((View) parent, id);
            } else {
                return false;
            }
        }
    }

    public EventTrackerCallback getCallback() {
        return callback;
    }

    public void setCallback(EventTrackerCallback callback) {
        this.callback = callback;
    }

}
