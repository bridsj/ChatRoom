package com.zuiapps.chat.room.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.zuiapps.chat.room.observer.ZUIObservable;
import com.zuiapps.chat.room.observer.ZUIObserver;

/**
 * Created by dengshengjin on 15/12/4.
 */
public abstract class ZUIBaseAdapter {
    private final ZUIObservable mZUIObservable = ZUIObservable.getInstance();

    public void registerObserver(ZUIObserver zuiObserver) {
        mZUIObservable.registerObserver(zuiObserver);
    }

    public void unregisterObserver(ZUIObserver zuiObserver) {
        mZUIObservable.unregisterObserver(zuiObserver);
    }

    public void notifyDataSetChanged() {
        mZUIObservable.notifyObservers();
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);

    public abstract int getCount();

    public abstract String getItem(int position);

    public abstract long getItemId(int position);
}
