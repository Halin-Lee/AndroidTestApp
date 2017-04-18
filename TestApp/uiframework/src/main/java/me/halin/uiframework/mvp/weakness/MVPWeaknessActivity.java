package me.halin.uiframework.mvp.weakness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import me.halin.uiframework.R;

public class MVPWeaknessActivity extends AppCompatActivity implements ViewInterface {

    private ListViewAdapter adapter;
    private Presenter presenter;
    private TextView textView;
    private Button button;
    private ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_weakness);
        this.presenter = new Presenter(this);
        adapter = new ListViewAdapter();
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);
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
        findViewById(R.id.button_update_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getNickname();
            }
        });

    }

    public void request() {

        this.presenter.start((String) textView.getText());

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.INVISIBLE);

        //UI显示操作
        textView.setText("Requesting");
    }

    public void requestNickname() {
        this.presenter.getNickname();
    }


    @Override
    public void onResult(List<String> list) {
        textView.setText(list.get(0));

        //动画
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.VISIBLE);

        //模型传递
        adapter.setItems(list);
    }

    @Override
    public void onNicknameResult(List<String> list) {

        //模型传递
        adapter.setNicknames(list);
    }
}
