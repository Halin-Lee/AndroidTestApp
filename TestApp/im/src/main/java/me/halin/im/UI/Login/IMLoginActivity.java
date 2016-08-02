package me.halin.im.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.im.R;
import me.halin.im.UI.Receive.IMReceiveActivity;
import me.halin.im.UI.Send.IMSendActivity;

public class IMLoginActivity extends AppCompatActivity {

    public static final String TAG = IMLoginActivity.class.getName();

    private EMClient emClient;

    private TextView connectionStateView;
    private EditText userNameView;
    private TextView loginStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immain);

        initView();

        emClient = EMClient.getInstance();
        emClient.groupManager().loadAllGroups();
        emClient.chatManager().loadAllConversations();
//        emClient.isLoggedInBefore();

        emClient.addConnectionListener(new EMConnectionListener() {
            @Override
            public void onConnected() {
                setConnectionState(true);
            }

            @Override
            public void onDisconnected(int i) {
                setConnectionState(false);
            }
        });

        initState();
    }


    //region view初始化及设置
    private void initView() {
        connectionStateView = (TextView) findViewById(R.id.connection_state);
        userNameView = (EditText) findViewById(R.id.user_name);
        loginStateView = (TextView) findViewById(R.id.login_state);

    }

    private void setConnectionState(final boolean isConnected) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String connectedStr = "连接状态:" + (isConnected ? "已连接" : "已断线");
                connectionStateView.setText(connectedStr);
            }
        });
    }

    private void setLoginState(final boolean isLogin) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String loginStateStr = "用户名:" +
                        emClient.getCurrentUser() + " 登录状态:" + (isLogin ? "已登录" : "未登录");
                loginStateView.setText(loginStateStr);
            }
        });


    }

    private void toast(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IMLoginActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //endregion

    private void initState() {
        setConnectionState(emClient.isConnected());
        setLoginState(emClient.isLoggedInBefore());

    }


    public void signUp(View v) {
        Logger.debug("注册");

        //注册需要异步
        new Thread() {

            @Override
            public void run() {
                String userName = userNameView.getText().toString();
                try {
                    emClient.createAccount(userName, userName);
                } catch (final HyphenateException e) {
                    Logger.logE(TAG, "注册失败,error:%s", e);

                    toast("注册失败,error:" + e);
                }
                setLoginState(emClient.isLoggedInBefore());
            }
        }.start();

    }

    public void signIn(View v) {
        String userName = userNameView.getText().toString();
        Logger.debug("登录");

        if (TextUtils.isEmpty(userName)) {
            toast("请输入用户名");
            return;
        }
        emClient.login(userName, userName, new EMCallBack() {
            @Override
            public void onSuccess() {
                Logger.debug("登录成功");
                setLoginState(true);
            }

            @Override
            public void onError(final int i, final String s) {
                Logger.debug("登录失败");
                toast("登录失败,code:" + i + "string:" + s);

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

    public void signOut(View v) {

        Logger.debug("退出");
        emClient.logout(true, new EMCallBack() {
            @Override
            public void onSuccess() {
                Logger.debug("退出成功");
                setLoginState(false);

            }

            @Override
            public void onError(final int i, final String s) {
                Logger.debug("登录失败");
                toast("退出失败,code:" + i + "string:" + s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }


    public void sendMessage(View v) {
        if (emClient.isLoggedInBefore()) {
            Intent intent = new Intent(this, IMSendActivity.class);
            startActivity(intent);
        } else {
            toast("请先登录");
        }
    }

    public void receiveMessage(View v) {
        if (emClient.isLoggedInBefore()) {
            Intent intent = new Intent(this, IMReceiveActivity.class);
            startActivity(intent);
        } else {
            toast("请先登录");
        }
    }
}
