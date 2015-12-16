package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadInterruptSleep extends Thread {
    private String TAG = ThreadInterruptSleep.class.getSimpleName();

    @Override
    public void run() {
        super.run();
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                if (i == 1) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(TAG + " " + i);
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadInterruptSleep threadInterrupt = new ThreadInterruptSleep();
        threadInterrupt.start();
    }
}