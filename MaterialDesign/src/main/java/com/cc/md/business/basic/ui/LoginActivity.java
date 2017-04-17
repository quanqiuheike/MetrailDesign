package com.cc.md.business.basic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.cc.md.R;


/**
 * Created by cheng.qx on 2016/12/2.
 */

public class LoginActivity extends BaseActivity {

    private Button mLoginButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mLoginButton= (Button) findViewById(R.id.login_bt);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }

}
