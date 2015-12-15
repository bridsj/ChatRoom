package com.zuiapps.chat.room;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dengshengjin on 15/12/15.
 */
public interface ViewCreator {
    View create(String name, Context context, AttributeSet attrs);
}

