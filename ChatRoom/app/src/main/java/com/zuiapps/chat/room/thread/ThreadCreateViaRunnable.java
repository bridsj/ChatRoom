package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadCreateViaRunnable implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new ThreadCreateViaRunnable()).start();
    }
}
