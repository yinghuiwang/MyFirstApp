package com.example.wangyinghui.a0720_myfirstapp.page.splash;

import android.app.Activity;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public interface SplashScreenContract {
    interface ISplashScreenView {
        void setPresenter(ISplashPresenter presenter);

        Activity getActivity();
    }

    interface ISplashPresenter {

        void jumpPage();
    }
}
