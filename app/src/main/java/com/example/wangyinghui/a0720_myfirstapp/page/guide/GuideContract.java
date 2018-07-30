package com.example.wangyinghui.a0720_myfirstapp.page.guide;

import android.app.Activity;
import com.example.wangyinghui.a0720_myfirstapp.page.splash.SplashScreenContract;

/**
 * Created by wangyinghui on 2018/7/23.
 */

public interface GuideContract {
    public interface IGuideView {
        void setPresenter(IGuidePresenter presenter);

        Activity getActivity();
    }

    public interface IGuidePresenter {
        public void jumpPage();
    }
}
