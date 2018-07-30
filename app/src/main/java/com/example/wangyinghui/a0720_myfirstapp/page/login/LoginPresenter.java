package com.example.wangyinghui.a0720_myfirstapp.page.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.example.wangyinghui.a0720_myfirstapp.bean.BaseBean;
import com.example.wangyinghui.a0720_myfirstapp.bean.UserInfo;
import com.example.wangyinghui.a0720_myfirstapp.impl.OnLoadListener;
import com.example.wangyinghui.a0720_myfirstapp.page.home.HomeActivity;
import com.example.wangyinghui.a0720_myfirstapp.utils.PreferenceUtil;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {

    public LoginContract.ILoginView iLoginView;
    public UserModel userModel = new UserModel();
    private Handler mHander;

    public LoginPresenter(LoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        mHander = new Handler(Looper.getMainLooper());
    }

    @Override public void clear() {
        iLoginView.onClearText();
    }

    @Override public void doLogin(String name, String password) {
        setProgressBarVisibility(View.VISIBLE);
        userModel.login(name, password, new OnLoadListener(){

            @Override public void onComplete(BaseBean baseBean) {
                setProgressBarVisibility(View.INVISIBLE);
                UserInfo userInfo = (UserInfo)baseBean;
                if (userInfo.getId() != null) {
                    PreferenceUtil preferenceUtil = new  PreferenceUtil();
                    preferenceUtil.setLoginState(true);
                    preferenceUtil.setToken(userInfo.id);
                    iLoginView.onLoginResult(true, -1);
                }
            }

            @Override public void onFailure(Throwable e, int code) {
                setProgressBarVisibility(View.INVISIBLE);
            }
        });
    }

    @Override public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    @Override public void jumpPage() {
        Intent intent = new Intent(iLoginView.getActivity(), HomeActivity.class);
        iLoginView.getActivity().startActivityForResult(intent, 0);
        iLoginView.getActivity().finish();
    }

}
