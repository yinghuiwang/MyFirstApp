package com.example.wangyinghui.a0720_myfirstapp.network;

import com.example.wangyinghui.a0720_myfirstapp.utils.EncryptUtil;
import com.example.wangyinghui.a0720_myfirstapp.utils.PreferenceUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyinghui on 2018/7/25.
 */

public class ServiceGenerator {
    public static final int CONNECT_TIMEOUT = 15;
    public static final int WRITE_TIMEOUT = 15;
    public static final int READ_TIMEOUT = 60;//read time out时间放大，部分接口服务器响应太慢
    public static final String BASE_URL = "https://d.apicloud.com/";
    public static final String API_ID = "A6087626194075";
    public static final String APP_KEY = "308C77FD-2889-81C9-DA40-56E30286EE0E";

    public static API getService(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl == null ? BASE_URL : baseUrl) // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .client(createOkHttpBuider().build())
            .build();

        // 步骤5:创建 网络请求接口 的实例
        API request = retrofit.create(API.class);
        return request;
    }

    public static OkHttpClient.Builder createOkHttpBuider() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                    .header("X-APICloud-AppId", API_ID)
                    .header("X-APICloud-AppKey", EncryptUtil.getSecurityAppKey(API_ID, APP_KEY))
                    .header("authorization", PreferenceUtil.getToken())
                    .method(original.method(), original.body())
                    .build();
                return chain.proceed(request);
            }
        });
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(httpLoggingInterceptor);
        return client;
    }
}
