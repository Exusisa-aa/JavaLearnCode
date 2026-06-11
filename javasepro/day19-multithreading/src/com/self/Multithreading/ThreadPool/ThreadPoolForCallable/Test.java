package com.self.Multithreading.ThreadPool.ThreadPoolForCallable;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(40,50,5,TimeUnit.SECONDS,new ArrayBlockingQueue<>(20),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable = new RunnableDemo();
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);
        es.execute(runnable);

        //线程池任务队列满了且核心线程都在忙，则调用临时线程，若临时线程也满了，则调用拒绝策略.
    }
}
