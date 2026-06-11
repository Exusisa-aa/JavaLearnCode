package com.self.Multithreading.ThreadPool.ThreadPoolForCallable;

public class RunnableDemo implements Runnable{
    @Override
    public synchronized void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + "执行了线程");
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
