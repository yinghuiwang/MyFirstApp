package com.example.wangyinghui.a0720_myfirstapp.network;

import java.util.HashMap;

/**
 * Created by wangyinghui on 2018/7/25.
 */

public class RequestHashMap extends HashMap<String, String> {
    @Override
    public String put(String key, String value) {
        if (value == null) {
            value = "";
        }
        return super.put(key, value);
    }
}
