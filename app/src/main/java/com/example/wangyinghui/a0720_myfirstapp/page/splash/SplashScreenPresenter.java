package com.example.wangyinghui.a0720_myfirstapp.page.splash;

import android.content.Intent;
import com.example.wangyinghui.a0720_myfirstapp.page.guide.GuideActivity;
import com.example.wangyinghui.a0720_myfirstapp.page.home.HomeActivity;
import com.example.wangyinghui.a0720_myfirstapp.page.login.LoginActivity;
import com.example.wangyinghui.a0720_myfirstapp.utils.PreferenceUtil;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class SplashScreenPresenter implements SplashScreenContract.ISplashPresenter {
    private SplashScreenContract.ISplashScreenView iSplashScreenView;

    public SplashScreenPresenter(SplashScreenContract.ISplashScreenView iSplashScreenView) {
        this.iSplashScreenView = iSplashScreenView;
        iSplashScreenView.setPresenter(this);
    }

    @Override public void jumpPage() {
        PreferenceUtil preferenceUtil = new  PreferenceUtil();
        if (preferenceUtil.getFirstStart()) {
            Intent intent = new Intent(iSplashScreenView.getActivity(), GuideActivity.class);
            iSplashScreenView.getActivity().startActivity(intent);
            iSplashScreenView.getActivity().finish();
            preferenceUtil.setFirstStart(false);
        }else if (preferenceUtil.getLoginState()) {
            Intent intent = new Intent(iSplashScreenView.getActivity(), HomeActivity.class);
            iSplashScreenView.getActivity().startActivityForResult(intent, 0);
            iSplashScreenView.getActivity().finish();
        } else {
            Intent intent = new Intent(iSplashScreenView.getActivity(), LoginActivity.class);
            iSplashScreenView.getActivity().startActivityForResult(intent, 0);
            iSplashScreenView.getActivity().finish();
        }
    }
}
