package com.self.Multithreading.CreateMultithreading.MethodTwo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) throws Exception{
        Callable<String> myCallable = new MyCallable(100);
        FutureTask<String> ft = new FutureTask<>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();

        System.out.println(ft.get());
    }
}
