package com.example.wangyinghui.a0720_myfirstapp;

import android.app.Application;

/**
 * Created by wangyinghui on 2018/7/26.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    @Override public void onCreate() {
        super.onCreate();
        instance = this;
    }

    // 返回
    public static MyApplication getInstance() {
        return instance;
    }
}
