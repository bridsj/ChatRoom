package com.zuiapps.chat.room.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadReentrantLock {
    private ReentrantLock lock = new ReentrantLock();

    private Object _lock = new Object();

    public void lockViaReentrant(String tag) {
        try {
            lock.lock();
            System.out.println("tag===" + tag);
        } finally {
            lock.unlock();
        }
    }

    public void lockViaSynchronized(String tag) {
        System.out.println("thread start " + tag + "," + System.currentTimeMillis());
        synchronized (_lock) {
            System.out.println("tag===" + tag + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        final ThreadReentrantLock threadTest4 = new ThreadReentrantLock();
        new Thread() {
            @Override
            public void run() {
                super.run();
//                threadTest4.lockViaReentrant("thread1");
                threadTest4.lockViaSynchronized("thread1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end " + System.currentTimeMillis());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                threadTest4.lockViaReentrant("thread2");
                threadTest4.lockViaSynchronized("thread2");
            }
        }.start();
    }
}
