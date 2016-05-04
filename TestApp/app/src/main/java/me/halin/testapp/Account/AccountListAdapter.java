package me.halin.testapp.Account;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by 17track on 4/19/16.
 */
public class AccountListAdapter extends BaseAdapter {


    private Context context;
    private Account[] mAccounts;

    public AccountListAdapter(Context context, Account[] mAccounts) {
        this.context = context;
        this.mAccounts = mAccounts;
    }

    @Override
    public int getCount() {
        return mAccounts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = new TextView(context);
        Account account = mAccounts[position];
        String text = "name:" + account.name + ",type:" + account.type + ",describeContents" + account.describeContents() + ",other:" + account.toString();
        ((TextView) convertView).setText(text);
        return convertView;
    }
}
