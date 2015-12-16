package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadWait {

    static class FirstThread extends Thread {
        private Object _lock;
        private String TAG = FirstThread.class.getSimpleName();

        public FirstThread(Object _lock) {
            this._lock = _lock;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    synchronized (_lock) {
                        Thread.sleep(1000);
                        if (i == 2) {
                            _lock.wait();
                        }
                        System.out.println(TAG + " " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SecondThread extends Thread {
        private Object _lock;
        private String TAG = SecondThread.class.getSimpleName();

        public SecondThread(Object _lock) {
            this._lock = _lock;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    synchronized (_lock) {
                        Thread.sleep(1000);
                        if (i == 2) {
                            _lock.notify();//标志1，添加了此句则firstThread可继续下去;否则firstThread不会继续了
                        }
                        System.out.println(TAG + " " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object _lock = new Object();
        FirstThread firstThread = new FirstThread(_lock);
        SecondThread secondThread = new SecondThread(_lock);
        firstThread.start();
        secondThread.start();
    }
}
//添加标志1
//        FirstThread 0
//        FirstThread 1
//        SecondThread 0
//        SecondThread 1
//        SecondThread 2
//        SecondThread 3
//        SecondThread 4
//        FirstThread 2
//        FirstThread 3
//        FirstThread 4

//未添加标志1
//        FirstThread 0
//        FirstThread 1
//        SecondThread 0
//        SecondThread 1
//        SecondThread 2
//        SecondThread 3
//        SecondThread 4