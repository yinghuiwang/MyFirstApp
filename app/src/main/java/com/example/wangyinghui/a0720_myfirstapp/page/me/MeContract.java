package com.example.wangyinghui.a0720_myfirstapp.page.me;

import android.app.Activity;

/**
 * Created by wangyinghui on 2018/7/26.
 */

public interface MeContract {
    interface IMeView {
        void setPresenter(IMePresenter presenter);

        Activity getActivity();
    }

    interface IMePresenter {

        void jumpPage();

        void logout();
    }
}
