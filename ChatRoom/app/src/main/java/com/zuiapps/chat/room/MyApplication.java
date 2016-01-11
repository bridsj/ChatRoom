package com.zuiapps.chat.room;

import android.app.Application;
import android.util.Log;

/**
 * Creator: dengshengjin on 16/1/5 20:33
 * Email: deng.shengjin@zuimeia.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("","MyApplication onCreate");
    }
}
