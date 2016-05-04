package me.halin.im.UI.Send;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

import java.io.File;
import java.io.FileNotFoundException;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.im.R;

/**
 * Created by 17track on 4/10/16.
 */
public class IMSendActivity extends AppCompatActivity {

    private EMClient emClient;

    private EditText sendToView;
    private EditText sendTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imsend);
        initView();
        emClient = EMClient.getInstance();


    }

    //region view初始化及设置
    private void initView() {
        sendToView = (EditText) findViewById(R.id.send_to);
        sendTextView = (EditText) findViewById(R.id.text);

    }
    //endregion

    public void sendText(View view) {

        String sendToUser = sendToView.getText().toString();
        if (TextUtils.isEmpty(sendToUser)) {
            toast("请输入发送对象");
            return;
        }

        //创建一条文本消息,content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
        EMMessage message = EMMessage.createTxtSendMessage(sendTextView.getText().toString(), sendToUser);

        //发送消息
        emClient.chatManager().sendMessage(message);
    }


    public void sendImage(View view) {
        String sendToUser = sendToView.getText().toString();
        if (TextUtils.isEmpty(sendToUser)) {
            toast("请输入发送对象");
            return;
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


        //打开图片加载
        Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        innerIntent.setType("image/*");
        //TODO:文本
        Intent wrapperIntent = Intent.createChooser(innerIntent, null);
        this.startActivityForResult(wrapperIntent, 0);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0:
                    //获得图片uri
                    Uri uri = data.getData();
                    if (uri != null) {
                        String path;
                        if (Build.VERSION.SDK_INT < 19){
                            path = getRealPathFromURI_API11to18(this,uri);
                        }else{
                            path = getRealPathFromURI_API19(this,uri);
                        }


                        String sendTo = sendToView.getText().toString();
                        Logger.debug("发送图片 %s %s", path ,sendTo);
                        //创建一条文本消息,content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
                        EMMessage message = EMMessage.createImageSendMessage(path, false, sendTo);
                        //发送消息
                        emClient.chatManager().sendMessage(message);
                    }

            }
        }
    }

    private void toast(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IMSendActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API19(Context context, Uri uri){
        String filePath = "";
        String wholeID = DocumentsContract.getDocumentId(uri);

        // Split at colon, use second item in the array
        String id = wholeID.split(":")[1];

        String[] column = { MediaStore.Images.Media.DATA };

        // where id is equal to
        String sel = MediaStore.Images.Media._ID + "=?";

        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                column, sel, new String[]{ id }, null);

        int columnIndex = cursor.getColumnIndex(column[0]);

        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }


    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        String result = null;

        CursorLoader cursorLoader = new CursorLoader(
                context,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        if(cursor != null){
            int column_index =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }



}
