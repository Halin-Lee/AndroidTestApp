package me.halin.testapp.AutoEventTracking;

import android.content.Context;
import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.halin.fundamental.LogUtil.Logger;

/**
 * 事件跟踪xml加载
 *
 * Created by Halin on 4/6/16.
 */
public class AutoEventTrackerXMLLoader {

    public static final String TAG = AutoEventTracker.class.getName();

    private static final AutoEventTrackerXMLLoader instance = new AutoEventTrackerXMLLoader();

    public static AutoEventTrackerXMLLoader getInstance() {
        return instance;
    }

    private HashMap<String, List<TrackEventItem>> itemMap = new HashMap<>();

    private HashMap<String, String> screenMap = new HashMap<>();

    public void loadFromXml(Context context, int id) {
        XmlResourceParser parser = context.getResources().getXml(id);

        List<TrackEventItem> itemList = new ArrayList<>();
        try {
            //如果没有到文件尾继续执行
            while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                //如果是开始标签
                if (parser.getEventType() == XmlResourceParser.START_TAG) {
                    //获取标签名称
                    String name = parser.getName();
                    //判断标签名称是否等于friend

                    switch (name) {
                        case "Screen":
                            //解析Activity标签
                            itemList = new ArrayList<>();
                            int attributeCount = parser.getAttributeCount();

                            String screenName = null;
                            String className = null;
                            for (int index = 0; index < attributeCount; index++) {
                                String attributeName = parser.getAttributeName(index);
                                switch (attributeName) {
                                    case "class":
                                        className = parser.getAttributeValue(index);
                                        break;
                                    case "name":
                                        screenName = parser.getAttributeValue(index);
                                        break;
                                }
                            }

                            if (className == null) {
                                Logger.logE(TAG, "Activity class 为空");
                            } else {
                                itemMap.put(className, itemList);
                                screenMap.put(className, screenName);
                            }

                            break;
                        case "item":

                            TrackEventItem item = new TrackEventItem();
                            attributeCount = parser.getAttributeCount();

                            for (int index = 0; index < attributeCount; index++) {
                                String attributeName = parser.getAttributeName(index);
                                switch (attributeName) {
                                    case "name":
                                        String itemName = parser.getAttributeValue(index);
                                        item.setName(itemName);
                                        break;
                                    case "type":
                                        String itemType = parser.getAttributeValue(index);
                                        item.setType(typeFromString(itemType));
                                        break;
                                    case "id":
                                        String itemId = parser.getAttributeValue(index);
                                        item.setId(idFromString(context, itemId));
                                        break;
                                    case "parent":
                                        String parent = parser.getAttributeValue(index);
                                        item.setParent(idFromString(context, parent));
                                        break;
                                    case "ignored":
                                        String ignored = parser.getAttributeValue(index);
                                        item.setIgnored(Boolean.parseBoolean(ignored));
                                        break;
                                    case "tag":
                                        String tag = parser.getAttributeValue(index);
                                        item.setTag(tag);
                                        break;
                                }
                            }
                            if (item.getId() <= 0) {
                                Logger.logE(TAG, "获得无效id id:%d name:%s", item.getId(), item.getName());
                            } else {
                                itemList.add(item);
                            }

                            break;
                    }
                } else if (parser.getEventType() == XmlPullParser.END_TAG) {
                } else if (parser.getEventType() == XmlPullParser.TEXT) {
                }
                //下一个标签
                parser.next();
            }

            Logger.log(TAG, "事件跟踪列表加载完成,事件表:%s,页面表:%s", itemMap, screenMap);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

    }

    public List<TrackEventItem> getItemForActivity(String activity) {

        if (itemMap.containsKey(activity)) {
            return new ArrayList<>(itemMap.get(activity));
        } else {
            return new ArrayList<>();
        }
    }

    public String getPageName(String activity) {
        String name = screenMap.get(activity);
        return name != null ? name : activity;
    }

    private int typeFromString(String type) {
        switch (type) {
            case "tap":
                return TrackEventItem.TYPE_TAP;
            case "scroll":
                return TrackEventItem.TYPE_SCROLL;
            case "fling":
                return TrackEventItem.TYPE_FLING;
            case "long press":
                return TrackEventItem.TYPE_LONG_PRESS;
        }
        return -1;
    }

    private int idFromString(Context context, String id) {
        if (id.matches("[0-9]+")) {
            return Integer.parseInt(id);
        } else {
            return context.getResources().getIdentifier(id, "id", context.getPackageName());
        }
    }
}
