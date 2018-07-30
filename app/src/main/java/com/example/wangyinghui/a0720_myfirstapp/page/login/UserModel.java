package com.example.wangyinghui.a0720_myfirstapp.page.login;

import android.util.Log;
import com.example.wangyinghui.a0720_myfirstapp.bean.UserInfo;
import com.example.wangyinghui.a0720_myfirstapp.impl.OnLoadListener;
import com.example.wangyinghui.a0720_myfirstapp.network.RequestHashMap;
import com.example.wangyinghui.a0720_myfirstapp.network.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class UserModel {

    public void login(String username, String password, final OnLoadListener onLoadListener) {
        RequestHashMap hashMap = new RequestHashMap();
        hashMap.put("username", username);
        hashMap.put("password", password);
        Call<UserInfo> call = ServiceGenerator.getService(null).login(hashMap);
        call.enqueue(new Callback<UserInfo>() {
            @Override public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                Log.d("wyh", "请求成功");
                onLoadListener.onComplete(response.body());
            }

            @Override public void onFailure(Call<UserInfo> call, Throwable t) {
                Log.d("wyh", "请求失败");
                onLoadListener.onFailure(t, '0');
            }
        });
    }
}
