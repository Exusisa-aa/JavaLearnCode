package com.self.Multithreading.CreateMultithreading.MethodThree;

public class ThreadTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程Main执行了" + i);
            //主线程一定要在单线程之后，否则不是多线程.
        }
    }
}
