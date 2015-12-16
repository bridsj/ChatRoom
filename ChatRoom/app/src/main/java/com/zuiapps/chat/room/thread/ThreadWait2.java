package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadWait2 {

    static class FirstThread extends Thread {
        private Object mLock = new Object();
        private String TAG = FirstThread.class.getSimpleName();

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
        private Object mLock = new Object();
        private String TAG = SecondThread.class.getSimpleName();

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    synchronized (mLock) {
                        Thread.sleep(1000);
                        if (i == 2) {

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
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        firstThread.start();
        secondThread.start();
    }
}

//        SecondThread 0
//        FirstThread 0
//        SecondThread 1
//        FirstThread 1
//        SecondThread 2
//        SecondThread 3
//        SecondThread 4