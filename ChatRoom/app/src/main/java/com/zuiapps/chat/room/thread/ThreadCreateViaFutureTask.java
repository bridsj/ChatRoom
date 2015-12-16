package com.zuiapps.chat.room.thread;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class ThreadCreateViaFutureTask {
    static class FutureTaskForMultiCompute extends FutureTask<Integer> {
        private ThreadLocal<Integer> mThreadLocal;

        public FutureTaskForMultiCompute(Callable<Integer> callable, int value) {
            super(callable);
            mThreadLocal = new ThreadLocal<>();
            setThreadLocal(value);
        }

        private int getThreadLocal() {
            return mThreadLocal.get();
        }

        private void setThreadLocal(int value) {
            mThreadLocal.set(value);
        }

    }

    class FutureCallable implements Callable<Integer> {
        private int mValue;

        public FutureCallable(int value) {
            mValue = value;
        }

        @Override
        public Integer call() throws Exception {
            return mValue + 1;
        }
    }

    public static void main(String[] args) {
        ThreadCreateViaFutureTask threadCreateViaFutureTask = new ThreadCreateViaFutureTask();
        final ConcurrentHashMap<Integer, FutureTaskForMultiCompute> mConcurrentPool = new ConcurrentHashMap<>();
        ExecutorService mExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            FutureTaskForMultiCompute futureTask = mConcurrentPool.get(i);
            if (futureTask != null) {
                continue;
            } else {
                FutureCallable futureCallable = threadCreateViaFutureTask.new FutureCallable(i);
                futureTask = new FutureTaskForMultiCompute(futureCallable, i);
                mConcurrentPool.putIfAbsent(i, futureTask);
                mExecutor.submit(futureTask);
            }
        }
        //等待前面的逻辑完成

        for (Map.Entry<Integer, FutureTaskForMultiCompute> entry : mConcurrentPool.entrySet()) {
            try {
                System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue().get() + "," + entry.getValue().getThreadLocal());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
            }
        }

    }
}
