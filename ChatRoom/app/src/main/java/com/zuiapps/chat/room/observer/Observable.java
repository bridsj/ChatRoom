package com.zuiapps.chat.room.observer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dengshengjin on 15/12/4.
 * 被观察者
 */
public abstract class Observable {
    protected List<Class<?>> mObservers = new LinkedList<>();

    public <T> void registerObserver(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        registerObserver(t.getClass());
    }

    public void registerObserver(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException();
        }
        synchronized (mObservers) {
            if (!mObservers.contains(cls)) {
                mObservers.add(cls);
            }
        }
    }

    public <T> void unregisterObserver(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        unregisterObserver(t.getClass());
    }

    public <T> void unregisterObserver(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException();
        }
        synchronized (mObservers) {
            Iterator<Class<?>> iterator = mObservers.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getName().equals(cls.getName())) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public void unregisterAll() {
        synchronized (mObservers) {
            mObservers.clear();
        }
    }

    public int countObservers() {
        synchronized (mObservers) {
            return mObservers.size();
        }
    }

    public abstract void notifyObservers(Object... objects);

    public abstract <T> void notifyObserver(T t, Object... objects);

    public abstract void notifyObserver(Class<?> cls, Object... objects);

}
