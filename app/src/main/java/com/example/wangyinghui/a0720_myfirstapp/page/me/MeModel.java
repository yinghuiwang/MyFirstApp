package com.example.wangyinghui.a0720_myfirstapp.page.me;

import com.example.wangyinghui.a0720_myfirstapp.bean.BaseBean;
import com.example.wangyinghui.a0720_myfirstapp.impl.OnLoadListener;
import com.example.wangyinghui.a0720_myfirstapp.network.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangyinghui on 2018/7/26.
 */

public class MeModel {

    public void logout(final OnLoadListener onLoadListener) {
        Call<BaseBean> call = ServiceGenerator.getService(null).logout();
        call.enqueue(new Callback() {
            @Override public void onResponse(Call call, Response response) {
                onLoadListener.onComplete(null);
            }

            @Override public void onFailure(Call call, Throwable t) {
                onLoadListener.onFailure(t, 0);
            }
        });
    }
}
