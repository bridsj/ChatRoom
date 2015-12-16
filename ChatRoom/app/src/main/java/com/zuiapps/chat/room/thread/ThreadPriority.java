package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/16.
 */
public class ThreadPriority extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "........."
                    + i);
        }
    }

    public static void main(String[] args) {
        ThreadPriority firstThread = new ThreadPriority();
        ThreadPriority secondThread = new ThreadPriority();
        firstThread.start();
        firstThread.setPriority(10);
        secondThread.start();
        secondThread.setPriority(1);
    }
}
