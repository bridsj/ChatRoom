package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/17.
 */
public class ThreadSynchronized extends Thread {
    private Object _lock;

    public ThreadSynchronized(String threadName, Object _lock) {
        super(threadName);
        this._lock = _lock;
    }

    public void run() {
        synchronized (_lock) {
            for (int i = 0; i < 40000; i++) {
                System.out.println(Thread.currentThread());
            }
        }
    }

    public static void main(String[] args) {
        Object _lock = new Object();
        ThreadSynchronized threadSynchronized = new ThreadSynchronized("thread1", _lock);
        threadSynchronized.start();
        ThreadSynchronized threadSynchronized2 = new ThreadSynchronized("thread2", _lock);
        threadSynchronized2.start();
    }
}
