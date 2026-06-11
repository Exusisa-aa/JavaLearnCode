package com.self.Multithreading.CreateMultithreading.MethodThree;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("字线程MyRunnable执行了" + i);
        }
    }
}
