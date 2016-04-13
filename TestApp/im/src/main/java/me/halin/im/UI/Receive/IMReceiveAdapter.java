package me.halin.im.UI.Receive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;

import java.util.List;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.im.R;

/**
 * Created by 17track on 4/10/16.
 */
public class IMReceiveAdapter extends BaseAdapter {


    public IMReceiveAdapter(List<EMMessage> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    private List<EMMessage> messages;

    private Context context;


    //region 消息显示
    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {

        EMMessage message = messages.get(position);

        return message.getType().ordinal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EMMessage message = messages.get(position);


        switch (message.getType()) {
            case TXT:
                if (convertView == null || !(convertView instanceof TextView)) {
                    convertView = new TextView(context);
                }
                TextView textView = (TextView) convertView;
                EMTextMessageBody textMessageBody = (EMTextMessageBody) message.getBody();
                textView.setText(textMessageBody.getMessage());

                break;
            case IMAGE:

                if (convertView == null || !(convertView instanceof ImageView)) {
                    convertView = new ImageView(context);
                }

                ImageView imageView = (ImageView) convertView;
                EMImageMessageBody imageMessageBody = (EMImageMessageBody) message.getBody();
                Bitmap bitmap = BitmapFactory.decodeFile(imageMessageBody.thumbnailLocalPath());
                Logger.debug("url:%s,Bitmap:%s", imageMessageBody.getThumbnailUrl(), bitmap);
                imageView.setImageBitmap(bitmap);

                break;
            default:
                return new View(context);
        }


        return convertView;
    }

    //endregion
}
