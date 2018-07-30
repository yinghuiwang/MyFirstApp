package com.example.wangyinghui.a0720_myfirstapp;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.example.wangyinghui.a0720_myfirstapp.bean.Translation;
import com.example.wangyinghui.a0720_myfirstapp.bean.TranslationYouDao;
import com.example.wangyinghui.a0720_myfirstapp.network.API;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyinghui on 2018/7/23.
 */

@RunWith(AndroidJUnit4.class) public class APITest {
    @Test public void jinShanTest() throws IOException {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build();

        // 步骤5:创建 网络请求接口 的实例
        API request = retrofit.create(API.class);

        //对 发送请求 进行封装
        Call<Translation> call = request.getCall();

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });
        ////步骤6:发送网络请求(同步)
        //Translation translation = call.execute().body();
        //
        //translation.show();
    }

    @Test public void youDouTest() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build();

        // 步骤5:创建 网络请求接口 的实例
        API request = retrofit.create(API.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<TranslationYouDao> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<TranslationYouDao>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<TranslationYouDao> call, Response<TranslationYouDao> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<TranslationYouDao> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }

    @Test public void loginTest() {

    }
}
