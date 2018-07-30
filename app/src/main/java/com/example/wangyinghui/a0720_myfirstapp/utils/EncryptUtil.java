package com.example.wangyinghui.a0720_myfirstapp.utils;

/**
 * Created by wangyinghui on 2018/7/25.
 */

public class EncryptUtil {
    public static String getSecurityAppKey(String apiId, String appKey) {
        String now = String.valueOf(System.currentTimeMillis());
        return ShaEncryptUtil.shaEncrypt(apiId + "UZ" +
            appKey + "UZ" + now) +
            "." + now;
    }
}
