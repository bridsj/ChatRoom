package com.zuiapps.chat.room.listview;

import android.content.Context;
import android.util.AttributeSet;

import com.zuiapps.chat.room.adapter.ZUIBaseAdapter;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class ZUIListView extends ZUIBaseListView {

    public ZUIListView(Context context) {
        super(context);
    }

    public ZUIListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZUIListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ZUIListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setAdapter(ZUIBaseAdapter adapter) {
        mAdapter = adapter;
    }

}
