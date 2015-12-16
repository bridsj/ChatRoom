package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadInterruptWait extends Thread {

    public static void main(String[] args) {
        ThreadInterruptWait threadInterrupt = new ThreadInterruptWait();
        threadInterrupt.start();
    }
}