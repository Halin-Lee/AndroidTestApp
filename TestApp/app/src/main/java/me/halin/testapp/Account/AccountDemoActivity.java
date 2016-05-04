package me.halin.testapp.Account;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import me.halin.fundamental.LogUtil.Logger;
import me.halin.testapp.R;


/**
 * Created by Halin on 4/19/16.
 */
public class AccountDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AccountManager accountManager;
    private Account[] mAccounts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.GET_ACCOUNTS)) {
                Toast.makeText(AccountDemoActivity.this, "没有GET_ACCOUNTS权限", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, 0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
//            }
                return;
            }


        }

        setupView();
    }

    private void setupView() {
        accountManager = AccountManager.get(this);
        //需要GET_ACCOUNTS,USE_CREDENTIALS权限
        mAccounts = accountManager.getAccounts();

        setContentView(R.layout.activity_account_demo);
        ListView listView = (ListView) findViewById(R.id.listview);
        AccountListAdapter adapter = new AccountListAdapter(this, mAccounts);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        setupView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Account account = mAccounts[position];
//        getTokenByBlocking(account);
        getTokenByAccountManagerFuture(account);
    }



    private void getTokenByBlocking(final Account account) {
        new Thread() {
            @Override
            public void run() {
                String authTokenType;
                switch (account.type) {

                    case "com.google":
                        authTokenType = "oauth2:https://www.googleapis.com/auth/userinfo.email";
                        break;
                    case "com.twitter.android.auth.login":
                        authTokenType = "com.twitter.android.oauth.token";
                        break;
                    case "com.facebook.auth.login":
                        authTokenType = "com.facebook.auth.login";
                        break;

                    default:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AccountDemoActivity.this, "未知账号", Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
                }
                String token = null;
                try {
                    token = accountManager.blockingGetAuthToken(account, authTokenType, true);
                } catch (OperationCanceledException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (AuthenticatorException e) {
                    e.printStackTrace();
                }

                Logger.debug("Token:" + token);
                Toast.makeText(AccountDemoActivity.this, "Token:" + token, Toast.LENGTH_LONG).show();
            }
        }.start();


    }

    private void getTokenByAccountManagerFuture(Account account) {
        Logger.debug("尝试获得%s token", account.type);
        // "oauth2:https://www.googleapis.com/auth/userinfo.email"表明需要获得email权限
        final AccountManagerFuture<Bundle> amf;
        switch (account.type) {

            case "com.google":
                amf = accountManager.getAuthToken(account,
                        "oauth2:https://www.googleapis.com/auth/userinfo.email",
                        null, this, null, null);
                break;
            case "com.twitter.android.auth.login":
                amf = accountManager.getAuthToken(account,
                        "com.twitter.android.oauth.token",
                        null, this, null, null);
                break;
            case "com.facebook.auth.login":
                amf = accountManager.getAuthToken(account,
                        "com.facebook.auth.login",
                        null, this, null, null);
                break;

            default:
                Toast.makeText(AccountDemoActivity.this, "未知账号", Toast.LENGTH_SHORT).show();
                return;
        }

        new AsyncTask<String, Integer, Bundle>() {
            @Override
            protected Bundle doInBackground(String... params) {
                try {
                    return amf.getResult();
                } catch (OperationCanceledException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (AuthenticatorException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bundle s) {
                super.onPostExecute(s);
                Logger.debug("Token:" + s);
                Toast.makeText(AccountDemoActivity.this, "Token:" + s, Toast.LENGTH_LONG).show();
            }
        }.execute();


    }

}
