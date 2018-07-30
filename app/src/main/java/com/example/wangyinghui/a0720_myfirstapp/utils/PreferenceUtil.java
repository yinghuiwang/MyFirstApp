package com.example.wangyinghui.a0720_myfirstapp.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.wangyinghui.a0720_myfirstapp.MyApplication;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class PreferenceUtil {
    private static final String LOGIN_STATE = "LoginState";
    private static final String FIRST_START = "firstStart";
    private static final String TOKEN = "token";

    private static SharedPreferences getPreferences() {
        Log.i("wyh", MyApplication.getInstance().toString());
        return MyApplication.getInstance().getSharedPreferences("MyFirstApp", Context.MODE_PRIVATE);
    }

    public static void setLoginState(boolean isLogin) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(LOGIN_STATE, isLogin);
        editor.apply();
    }

    public static boolean getLoginState() {
        return getPreferences().getBoolean(LOGIN_STATE, false);
    }

    public static void setFirstStart(boolean isFirstStart) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(FIRST_START, isFirstStart);
        editor.apply();
    }

    public static boolean getFirstStart() {
        return getPreferences().getBoolean(FIRST_START, true);
    }

    public static void setToken(String token) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }

    public static String getToken() {
        return getPreferences().getString(TOKEN, "");
    }

    public static void clear() {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.clear();
        editor.apply();
    }
}
