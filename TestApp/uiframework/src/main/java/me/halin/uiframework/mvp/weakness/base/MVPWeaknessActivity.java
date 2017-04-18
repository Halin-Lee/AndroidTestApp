package me.halin.uiframework.mvp.weakness.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        this.textView.setText("Ready");

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    public void request() {

        this.presenter.start((String) textView.getText());
        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.INVISIBLE);

        textView.setText("Requesting");
    }

    @Override
    public void onResult(List<String> list) {
        textView.setText(list.get(0));

        TransitionManager.beginDelayedTransition(this.content);
        button.setVisibility(View.VISIBLE);

        adapter.setItems(list);

    }

}
