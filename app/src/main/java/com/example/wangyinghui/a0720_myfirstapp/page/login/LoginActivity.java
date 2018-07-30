package com.example.wangyinghui.a0720_myfirstapp.page.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.wangyinghui.a0720_myfirstapp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView, View.OnClickListener {
    private EditText mETUsername;
    private EditText mETPassword;
    private Button mBtnLogin;
    private Button mBtnClear;
    private ProgressBar mProgressBar;

    public LoginContract.ILoginPresenter mLoginPresenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        // find view
        mETUsername = this.findViewById(R.id.et_username);
        mETPassword = this.findViewById(R.id.et_password);
        mBtnLogin = this.findViewById(R.id.btn_login);
        mBtnClear = this.findViewById(R.id.btn_clear);
        mProgressBar = this.findViewById(R.id.progressBar);

        // set listener
        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

        // init;
        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.setProgressBarVisibility(View.INVISIBLE);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mBtnLogin.setEnabled(false);
                mBtnClear.setEnabled(false);
                mLoginPresenter.doLogin(mETUsername.getText().toString(), mETPassword.getText().toString());
                break;
            case R.id.btn_clear:
                mLoginPresenter.clear();
                break;
        }
    }

    @Override public void onClearText() {
        mETUsername.setText("");
        mETPassword.setText("");
    }

    @Override public void onLoginResult(Boolean result, int code) {
        mBtnLogin.setEnabled(true);
        mBtnClear.setEnabled(true);
        if (result) {
            mLoginPresenter.jumpPage();
        } else {
            Toast.makeText(this, "Login fail, code = " + code, Toast.LENGTH_LONG).show();
        }
    }

    @Override public void onSetProgressBarVisibility(int visibility) {
        mProgressBar.setVisibility(visibility);
    }

    @Override public Activity getActivity() {
        return this;
    }
}
