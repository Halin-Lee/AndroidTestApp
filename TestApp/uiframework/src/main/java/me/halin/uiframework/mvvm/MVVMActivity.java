package me.halin.uiframework.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import me.halin.uiframework.R;
import me.halin.uiframework.databinding.ActivityMvvmBinding;

public class MVVMActivity extends AppCompatActivity {


    private ListViewAdapter adapter;
    private MainViewModel mainViewModel;
    private TextView textView;
    private Button button;
    private ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //构造ViewModel
        mainViewModel = new MainViewModel();
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setViewModel(mainViewModel);


        adapter = new ListViewAdapter(mainViewModel);
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
        findViewById(R.id.button_update_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestNickname();
            }
        });

        //绑定动画
        mainViewModel.requesting.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                TransitionManager.beginDelayedTransition(content);
                if (mainViewModel.requesting.get()) {
                    button.setVisibility(View.GONE);
                } else {
                    button.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void request() {
        mainViewModel.start((String) textView.getText());
        textView.setText("Requesting");
    }

    public void requestNickname() {
        mainViewModel.getNickname();
    }

}
