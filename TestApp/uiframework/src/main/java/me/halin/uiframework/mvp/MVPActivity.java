package me.halin.uiframework.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.halin.uiframework.R;
import me.halin.uiframework.SampleModel;

public class MVPActivity extends AppCompatActivity implements ViewInterface {

    private Presenter presenter;
    private TextView textView;
    private Button button;
    private ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new Presenter(this);
        setContentView(R.layout.activity_mvp);

        this.button = (Button) findViewById(R.id.button);
        this.textView = (TextView) findViewById(R.id.text);
        this.content = (ViewGroup) findViewById(R.id.content);

        //UI显示操作
        this.textView.setText("Ready");

        //绑定事件
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    public void request() {

        //转发业务
        this.presenter.start((String) textView.getText());

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.GONE);

        //UI显示操作
        textView.setText("Requesting");
    }


    @Override
    public void onResult(List<String> list) {

        //UI显示操作
        textView.setText(list.get(0));

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.VISIBLE);
    }
}
