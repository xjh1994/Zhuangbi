package com.xjh1994.zhuangbi;

import android.app.Application;

/**
 * Created by xjh1994 on 2016/6/29.
 */
public class CustomApplication extends Application {
    private static CustomApplication instance;

    public static CustomApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
