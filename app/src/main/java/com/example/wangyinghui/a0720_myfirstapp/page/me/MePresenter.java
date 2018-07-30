package com.example.wangyinghui.a0720_myfirstapp.page.me;

import android.content.Intent;
import com.example.wangyinghui.a0720_myfirstapp.bean.BaseBean;
import com.example.wangyinghui.a0720_myfirstapp.impl.OnLoadListener;
import com.example.wangyinghui.a0720_myfirstapp.page.login.LoginActivity;

/**
 * Created by wangyinghui on 2018/7/26.
 */

public class MePresenter implements MeContract.IMePresenter {

    private MeContract.IMeView iMeView;
    private MeModel meModel = new MeModel();
    public MePresenter(MeContract.IMeView iMeView) {
       this.iMeView = iMeView;
       iMeView.setPresenter(this);
    }

    @Override public void jumpPage() {
        Intent intent = new Intent(iMeView.getActivity(), LoginActivity.class);
        iMeView.getActivity().startActivity(intent);
        iMeView.getActivity().finish();
    }

    @Override public void logout() {
        meModel.logout(new OnLoadListener() {
            @Override public void onComplete(BaseBean baseBean) {
                jumpPage();
            }

            @Override public void onFailure(Throwable e, int code) {

            }
        });
    }
}
