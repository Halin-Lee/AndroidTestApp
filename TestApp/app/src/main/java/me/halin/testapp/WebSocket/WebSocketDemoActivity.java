package me.halin.testapp.WebSocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.Locale;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.R;


/**
 * Created by Halin on 8/1/16.
 */
public class WebSocketDemoActivity extends AppCompatActivity {

    public static final String TAG = WebSocketDemoActivity.class.getName();
    WebSocketClient client;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websocket_demo);
        textView = (TextView) findViewById(R.id.log_text);
        editText = (EditText) findViewById(R.id.editText);
        WebSocketImpl.DEBUG = true;

        new Thread() {
            @Override
            public void run() {
                try {

                    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.31", 3128));
                    HttpURLConnection connection = (HttpURLConnection) new URL("http://192.168.1.36:8000/JavaWebTestApp/WebSocket/WebSocketDemo.html").openConnection(proxy);
                    connection.setRequestMethod("GET");
                    final int bufferSize = 1024;
                    final char[] buffer = new char[bufferSize];
                    final StringBuilder out = new StringBuilder();
                    Reader in = new InputStreamReader(connection.getInputStream());
                    for (; ; ) {
                        int rsz = in.read(buffer, 0, buffer.length);
                        if (rsz < 0)
                            break;
                        out.append(buffer, 0, rsz);
                    }
                    System.out.println("收到结果:" + out.toString());
                } catch (IOException e) {
                    System.out.println("收到结果:" + e);
                }
            }
        }.start();

    }


    public void connect(View v) {
        if (client == null || client.getConnection().isClosed()) {
            client = new WebSocketClient(URI.create("ws://192.168.1.36:8000/JavaWebTestApp/WebSocket/DemoWebSocketServer"), new Draft_17()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    append("握手成功 " + handshakedata);
                }

                @Override
                public void onMessage(String message) {
                    append("收到" + message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    String logString = String.format(Locale.ENGLISH, "链接关闭 code:%d,reason:%s,isRemote:%b", code, reason, remote);
                    append(logString);
                }

                @Override
                public void onError(Exception ex) {
                    Logger.log(TAG, "异常:" + ex);
                }
            };
            client.connect();
            append("连接服务器");
        } else {
            append("已连接");
        }

    }

    public void send(View v) {
        String message = editText.getText().toString();
        append("发送:" + message);
        client.send(message);
    }

    public void close(View v) {
        client.close();
        append("已断开");
    }

    private void append(final String str) {

        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.append(str + "\r\n");
            }
        });
    }
}
