package me.halin.android.ui.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import me.halin.android.ui.R;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        //toolbar只有在Activity的theme为NoActionBar才启用
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

//        inflateMenu只有在Toolbar作为单独控件存在时才有效，setSupportActionBar后，toolbar将自动作为Activity的ActionBar，其所有的行为由Activity控制，下面的inflateMenu也就没有用了，
//        toolbar.inflateMenu(R.menu.tool_bar_activity_menu);


        //这部分需要先设置supportActionBar再更换NavigationIcon,否则NavigationIcon不起作用
        //允许navigation左上角点击
        getSupportActionBar().setHomeButtonEnabled(true);
        //home按键是否允许回退(如果允许显示回退,则无法自定义NavigationIcon)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleMarginStart(8);
        toolbar.setTitle(R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_activity_menu, menu);
        //寻找与修改item
        menu.getItem(3).setTitle("Title 3");
        menu.findItem(R.id.item_c).setIcon(android.R.drawable.ic_menu_call);
        //默认更多弹窗是没有icon的
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
