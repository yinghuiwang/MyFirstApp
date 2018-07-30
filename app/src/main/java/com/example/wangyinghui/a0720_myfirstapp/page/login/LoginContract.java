package com.example.wangyinghui.a0720_myfirstapp.page.login;

import android.app.Activity;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public interface LoginContract {
    interface ILoginView {
        public void onClearText();
        public void onLoginResult(Boolean result, int code);
        public void onSetProgressBarVisibility(int visibility);
        public Activity getActivity();
    }

    interface ILoginPresenter {
        public void clear();
        public void doLogin(String name, String password);
        public void setProgressBarVisibility(int visibility);
        public void jumpPage();
    }
}
