package com.example.wangyinghui.a0720_myfirstapp;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.example.wangyinghui.a0720_myfirstapp.network.ServiceGenerator;
import com.example.wangyinghui.a0720_myfirstapp.utils.EncryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by wangyinghui on 2018/7/26.
 */

@RunWith(AndroidJUnit4.class) public class EncyptUtilTest {
    @Test public void generatorAppKey() {
        Log.i("wyh", EncryptUtil.getSecurityAppKey(ServiceGenerator.API_ID, ServiceGenerator.APP_KEY));
    }
}
