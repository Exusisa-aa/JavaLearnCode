package com.self.Multithreading.ThreadPool.ThreadPoolForRunnable;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallableDemo implements Callable<String> {
    private int n;
    Lock lk = new ReentrantLock();

    public CallableDemo(int n)
    {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        try {
            lk.lock();
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            return Thread.currentThread().getName() + "的结果为" + sum;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lk.unlock();
        }
    }
}
