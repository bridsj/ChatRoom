package com.zuiapps.chat.room.observer;

import java.lang.reflect.Method;

/**
 * Created by dengshengjin on 15/12/4.
 * 具体被观察者
 */
public class ZUIObservable extends Observable {
    private static ZUIObservable mZUIObservable;

    private ZUIObservable() {

    }

    //懒汉单例
    public static ZUIObservable getInstance() {
        if (mZUIObservable == null) {
            synchronized (ZUIObservable.class) {
                if (mZUIObservable == null) {
                    mZUIObservable = new ZUIObservable();
                }
            }
        }
        return mZUIObservable;
    }

    @Override
    public void notifyObservers(Object... objects) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                this.notifyObserver(mObservers.get(i), objects);
            }
        }
    }

    @Override
    public <T> void notifyObserver(T t, Object... objects) {
        if (t == null) {
            throw new NullPointerException();
        }
        this.notifyObserver(t.getClass());
    }

    @Override
    public void notifyObserver(Class<?> cls, Object... objects) {
        if (cls == null) {
            throw new NullPointerException();
        }
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("update")) {
                try {
                    method.invoke(cls, objects);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                break;
            }
        }
    }
}
