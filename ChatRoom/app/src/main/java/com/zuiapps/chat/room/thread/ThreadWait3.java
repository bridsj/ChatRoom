package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadWait3 {

    static class FirstThread extends Thread {
        private Object mLock;
        private String TAG = FirstThread.class.getSimpleName();

        public FirstThread(Object lock) {
            mLock = lock;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    synchronized (mLock) {
                        Thread.sleep(1000);
                        if (i == 2) {
                            mLock.wait();
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
        private Object mGlobalLock;
        private String TAG = SecondThread.class.getSimpleName();

        public SecondThread(Object globalLock) {
            mGlobalLock = globalLock;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    if (i == 3) {
                        synchronized (mGlobalLock) {
                            mGlobalLock.notify();
                        }
                    }
                    System.out.println(TAG + " " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object mGlobalLock = new Object();
        FirstThread firstThread = new FirstThread(mGlobalLock);
        SecondThread secondThread = new SecondThread(mGlobalLock);
        firstThread.start();
        secondThread.start();
    }
}
//        FirstThread 0
//        SecondThread 0
//        FirstThread 1
//        SecondThread 1
//        SecondThread 2
//        SecondThread 3
//        FirstThread 2
//        SecondThread 4
//        FirstThread 3
//        FirstThread 4