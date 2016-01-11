package com.zuiapps.chat.room;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Creator: dengshengjin on 16/1/6 16:14
 * Email: deng.shengjin@zuimeia.com
 */
public class Test2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Log.e("", "TestActivity" + findViewById(R.id.test_box).getId());
    }
}
