package me.halin.uiframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.halin.uiframework.mvc.MVCActivity;
import me.halin.uiframework.mvp.MVPActivity;
import me.halin.uiframework.mvp.weakness.MVPWeaknessActivity;
import me.halin.uiframework.mvvm.MVVMActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_mvc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVCActivity.class));
            }
        });
        findViewById(R.id.button_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVPActivity.class));
            }
        });
        findViewById(R.id.button_mvp_weakness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVPWeaknessActivity.class));
            }
        });
        findViewById(R.id.button_mvvm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVVMActivity.class));
            }
        });
    }
}
