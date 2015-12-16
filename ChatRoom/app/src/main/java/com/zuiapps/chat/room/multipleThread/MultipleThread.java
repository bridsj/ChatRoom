package com.zuiapps.chat.room.multipleThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by dengshengjin on 15/12/16.
 */
public class MultipleThread {
    static class Producer extends Thread {
        private Queue<Integer> mQueue;
        private int mMaxSize;

        public Producer(String threadName, Queue<Integer> queue, int maxSize) {
            super(threadName);
            mQueue = queue;
            mMaxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mQueue) {
                    while (mQueue.size() == mMaxSize) {
                        try {
                            mQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int random = new Random().nextInt();
                    mQueue.add(random);
                    System.out.println(getThreadName() + "开始生成");
                    mQueue.notifyAll();//唤醒所有线程占用mQueue 的对象
                }
            }
        }

        private String getThreadName(){
            return getName();
        }
    }

    static class Consumer extends Thread {
        private Queue<Integer> mQueue;
        private int mMaxSize;

        public Consumer(String threadName, Queue<Integer> queue, int maxSize) {
            super(threadName);
            mQueue = queue;
            mMaxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mQueue) {
                    while (mQueue.isEmpty()) {
                        System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
                        try {
                            mQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mQueue.remove();
                    System.out.println(getName() + "开始消费");
                    mQueue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer = new Producer("Producer", buffer, maxSize);
        Thread consumer = new Consumer("Consumer", buffer, maxSize);
        producer.start();
        consumer.start();
    }

}
