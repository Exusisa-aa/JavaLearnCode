package com.self.Multithreading.CreateMultithreading.MethodTwo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception{
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() {
                int n = 100;
                int sum = 0;
                for (int i = 0; i <= n; i++) {
                    sum += i;
                }
                return "1到" + n + "的和为：" + sum;
            }
        });

        Thread thread = new Thread(ft);
        thread.start();

        System.out.println(ft.get());
    }
}
