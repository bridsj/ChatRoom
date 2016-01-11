package com.zuiapps.chat.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Creator: dengshengjin on 16/1/6 16:14
 * Email: deng.shengjin@zuimeia.com
 */
public class Test1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        Log.e("", "TestActivity 2 " + findViewById(R.id.test_box).getId());
        findViewById(R.id.test_box).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test1Activity.this, Test2Activity.class));
            }
        });
    }
}
