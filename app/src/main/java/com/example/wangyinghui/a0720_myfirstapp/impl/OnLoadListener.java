package com.example.wangyinghui.a0720_myfirstapp.impl;

import com.example.wangyinghui.a0720_myfirstapp.bean.BaseBean;

/**
 * Created by wangyinghui on 2018/7/26.
 */

public interface OnLoadListener {

    void onComplete(BaseBean baseBean);

    void onFailure(Throwable e, int code);
}
