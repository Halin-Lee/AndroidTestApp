package me.halin.uiframework.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.halin.uiframework.R;
import me.halin.uiframework.SampleModel;

/**
 * 基础MVC示例
 */
public class MVCActivity extends AppCompatActivity {


    private TextView textView;
    private Button button;
    private ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        this.button = (Button) findViewById(R.id.button);
        this.textView = (TextView) findViewById(R.id.text);
        this.content = (ViewGroup) findViewById(R.id.content);

        //UI显示操作
        this.textView.setText("Ready");

        //事件绑定
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    public void request() {

        //业务
        List<String> list = new ArrayList();
        list.add((String) textView.getText());
        new SampleModel().start(list, new SampleModel.Callback() {
            @Override
            public void callback(List<String> list) {
                requestFinish(list);
            }
        });

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.GONE);

        //UI显示操作
        textView.setText("Requesting");
    }


    public void requestFinish(List<String> list) {

        //UI显示操作
        textView.setText(list.get(0));

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.VISIBLE);
    }
}
