package com.zuiapps.chat.room.thread;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadJoin {
    static class ParentThread extends Thread {
        private ChildThread mChildThread;
        private String TAG = ParentThread.class.getSimpleName();

        public ParentThread(ChildThread childThread) {
            mChildThread = childThread;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    if (i == 2 && mChildThread != null) {
                        mChildThread.join();//等待子线程执行完，child 执行synchronized (lock)进入阻塞,获取了childThread的对象锁，需要等该对象的对象锁释放
                    }
                    System.out.println(TAG + " " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ChildThread extends Thread {
        private String TAG = ChildThread.class.getSimpleName();

        public ChildThread() {
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

    public static void main(String[] args) {
        String TAG = Thread.currentThread().getName();

        System.out.println(TAG + " start");
        ChildThread childThread = new ChildThread();
        ParentThread parentThread = new ParentThread(childThread);
        parentThread.start();
        childThread.start();
        try {
            // 当main线程调用parentThread.join时候，main线程会获得线程对象parentThread的锁（wait 意味着拿到该对象的锁),
            // 调用该对象的wait(等待时间)，直到该对象唤醒main线程 ，比如退出后。这就意味着main 线程调用parentThread.join时，必须能够拿到线程parentThread对象的锁
            parentThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(TAG + " end");
    }
}
//        main start
//        ParentThread 0
//        ChildThread 0
//        ParentThread 1
//        ChildThread 1
//        ChildThread 2
//        ChildThread 3
//        ChildThread 4
//        ParentThread 2
//        ParentThread 3
//        ParentThread 4
//        main end