package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadInterruptJoin extends Thread {
    private String TAG = ThreadInterruptJoin.class.getSimpleName();

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                if (i == 3) {
                    interrupt();
                }
                System.out.println(TAG + " " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadInterruptJoin threadInterrupt = new ThreadInterruptJoin();
        threadInterrupt.start();

        String TAG = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                if (i == 0) {
                    threadInterrupt.join();
                }
                System.out.println(TAG + " " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}