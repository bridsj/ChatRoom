package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/16.
 */
public class ThreadDaemon {

    static class NormalThread extends Thread {
        private String TAG = NormalThread.class.getSimpleName();

        public void startThread() {
            start();
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(TAG + " " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class DaemonThread extends Thread {
        private String TAG = DaemonThread.class.getSimpleName();

        public void startThread() {
            setDaemon(true);
            start();
        }

        @Override
        public void run() {
            super.run();
            super.run();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(TAG + " " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new NormalThread().startThread();
        new DaemonThread().startThread();
    }
}

//        DaemonThread 0
//        NormalThread 0
//        DaemonThread 1
//        NormalThread 1
//        NormalThread 2
//        DaemonThread 2
//        DaemonThread 3
//        NormalThread 3
//        DaemonThread 4
//        NormalThread 4
