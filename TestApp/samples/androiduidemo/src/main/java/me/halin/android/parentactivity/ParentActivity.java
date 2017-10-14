package me.halin.android.parentactivity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import me.halin.android.R;
import me.halin.android.main.MainActivity;
import me.halin.android.ui.cardview.CardViewActivity;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.new_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(v);
            }
        });
        findViewById(R.id.new_affinity_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAffinityActivity(v);
            }
        });

        findViewById(R.id.navigate_up_from_same_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateUpFromSameTask();
            }
        });
        findViewById(R.id.navigate_up_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateUpTo();
            }
        });
        findViewById(R.id.add_next_intent_with_parent_stack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextIntentWithParentStack();
            }
        });

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    //判断是否可以回退，不可以则自行构造父Activity
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }


//                TaskStackBuilder.create(this)
//                        // Add all of this activity's parents to the back stack
//                        .addNextIntentWithParentStack(new Intent(this, CardViewActivity.class))
//                        .addNextIntentWithParentStack(new Intent(this, CardViewActivity.class))
//                        // Navigate up to the closest parent
//                        .startActivities();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void newActivity(View view) {
        startActivity(new Intent(this, this.getClass()));
    }

    public void newAffinityActivity(View view) {
        Intent intent = new Intent(this, ParentDiffAffinityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void navigateUpFromSameTask() {
        NavUtils.navigateUpFromSameTask(this);
    }

    public void navigateUpTo() {
        //从task中寻找对应的Activity，找得到就退到这个Activity，否则完全退出
        NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
    }

    public void addNextIntentWithParentStack() {
        TaskStackBuilder.create(this)
                // Add all of this activity's parents to the back stack
                .addNextIntentWithParentStack(new Intent(this, CardViewActivity.class))
                .addNextIntentWithParentStack(new Intent(this, CardViewActivity.class))
                // Navigate up to the closest parent
                .startActivities();
    }

}
