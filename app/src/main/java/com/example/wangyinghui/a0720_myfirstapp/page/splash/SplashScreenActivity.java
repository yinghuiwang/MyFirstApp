package com.example.wangyinghui.a0720_myfirstapp.page.splash;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.example.wangyinghui.a0720_myfirstapp.R;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenContract.ISplashScreenView {
    private SplashScreenContract.ISplashPresenter presenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_splash_screen);

        new SplashScreenPresenter(this);

        presenter.jumpPage();

    }

    @Override public void setPresenter(SplashScreenContract.ISplashPresenter presenter) {
        this.presenter = presenter;
    }

    @Override public Activity getActivity() {
        return this;
    }
}
