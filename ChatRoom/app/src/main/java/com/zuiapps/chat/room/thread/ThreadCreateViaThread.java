package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadCreateViaThread extends Thread {

    @Override
    public void run() {
        super.run();
        enter();
    }

    private void enter() {
        for (int i = 0; i < 30; i++) {//1
            print(i);//2
        }
    }

    private void print(int i) {
        System.out.println(Thread.currentThread().getName() + " " + i);//3
        System.out.println(Thread.currentThread().getName() + " " + i);
        System.out.println(Thread.currentThread().getName() + " " + i);
        System.out.println(Thread.currentThread().getName() + " " + i);
        System.out.println(Thread.currentThread().getName() + " " + i);
        String name = getThreadName();//4
        System.out.println(name + " " + i);//5
    }

    private String getThreadName() {
        String tmp = "b";
        tmp+="sdfdsfsd";
        return Thread.currentThread().getName();//6
    }

    public static void main(String[] args) {
        new ThreadCreateViaThread().start();
    }
}

//断点：2 3 4
//F5 单步调试 4执行时会进入6  （单步调试进入具体方法）
//F6 单步调试 4执行时不会进入6 (单步调试不进入具体方法)
//F7 2->3执行完执行4，执行完4跳出该方法，执行1 (执行完当前方法，并跳出此方法)
//F8 2->3执行完执行4，执行完4执行2 (调至下一个断点)


