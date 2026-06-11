package com.self.Multithreading.ThreadPool.ThreadPoolForRunnable;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception{
        ExecutorService es = new ThreadPoolExecutor(3,5,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(4),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Callable<String> myCallable1 = new CallableDemo(100);
        Future<String> f1 = es.submit(myCallable1);
        System.out.println(f1.get());

        Callable<String> myCallable2 = new CallableDemo(200);
        Future<String> f2 = es.submit(myCallable2);
        System.out.println(f2.get());

        Callable<String> myCallable3 = new CallableDemo(300);
        Future<String> f3 = es.submit(myCallable3);
        System.out.println(f3.get());
        

        es.shutdown();
    }
}
