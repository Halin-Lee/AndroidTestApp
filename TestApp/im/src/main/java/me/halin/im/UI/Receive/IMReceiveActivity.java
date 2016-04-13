package me.halin.im.UI.Receive;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;

import java.util.ArrayList;
import java.util.List;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.im.R;

/**
 * Created by 17track on 4/10/16.
 */
public class IMReceiveActivity extends AppCompatActivity implements EMMessageListener {
    public static final String TAG = IMReceiveActivity.class.getName();

    private EMClient emClient;
    private EMChatManager chatManager;

    private List<EMMessage> messages = new ArrayList<>();

    private ListView messageListView;
    private IMReceiveAdapter messageListAdapter;
    private EditText userNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imreceive);
        userNameView = (EditText) findViewById(R.id.user_name);

        emClient = EMClient.getInstance();
        chatManager = emClient.chatManager();
        chatManager.addMessageListener(this);

        messageListView = (ListView) findViewById(R.id.message_list);

        messageListAdapter = new IMReceiveAdapter(messages, this);
        messageListView.setAdapter(messageListAdapter);
    }

    @Override
    protected void onDestroy() {
        chatManager.removeMessageListener(this);
        super.onDestroy();

    }


    //region 消息接收
    @Override
    public void onMessageReceived(final List<EMMessage> list) {
        Logger.debug("收到消息:%s", list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messages.addAll(list);
                messageListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageReadAckReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageDeliveryAckReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageChanged(EMMessage emMessage, Object o) {

    }

    public void loadMessage(View view) {
        String userName = userNameView.getText().toString();
        EMConversation conversation = chatManager.getConversation(userName);
        List<EMMessage> localMessages = conversation.getAllMessages();
        messages.addAll(localMessages);
        messageListAdapter.notifyDataSetChanged();
        Logger.debug("加载本地聊天记录 %s", localMessages);
    }

    //endregion


}
