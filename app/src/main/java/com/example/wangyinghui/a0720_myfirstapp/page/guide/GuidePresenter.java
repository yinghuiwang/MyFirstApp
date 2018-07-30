package com.example.wangyinghui.a0720_myfirstapp.page.guide;

import android.content.Intent;
import com.example.wangyinghui.a0720_myfirstapp.page.home.HomeActivity;
import com.example.wangyinghui.a0720_myfirstapp.page.login.LoginActivity;
import com.example.wangyinghui.a0720_myfirstapp.utils.PreferenceUtil;

/**
 * Created by wangyinghui on 2018/7/23.
 */

public class GuidePresenter implements GuideContract.IGuidePresenter {
    private GuideContract.IGuideView iGuideView;
    public GuidePresenter(GuideContract.IGuideView iGuideView) {
        this.iGuideView = iGuideView;
        iGuideView.setPresenter(this);
    }
    @Override public void jumpPage() {
        Intent intent = new Intent(iGuideView.getActivity(), LoginActivity.class);
        iGuideView.getActivity().startActivity(intent);
        iGuideView.getActivity().finish();
    }
}
