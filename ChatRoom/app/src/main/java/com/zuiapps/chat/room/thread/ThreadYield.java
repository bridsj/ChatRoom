package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadYield extends Thread {
    private String mName;

    public ThreadYield(String name) {
        mName = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            System.out.println("" + mName + "-----" + i);
            if (i == 30) {
                yield();
            }
        }
    }

    public static void main(String[] args) {
        ThreadYield firstThread = new ThreadYield("Thread a");
        ThreadYield secondThread = new ThreadYield("Thread b");
        firstThread.start();
        secondThread.start();
    }
}