package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadTest2 implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new ThreadTest2()).start();
    }
}
