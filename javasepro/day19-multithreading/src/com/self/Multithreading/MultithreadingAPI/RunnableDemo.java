package com.self.Multithreading.MultithreadingAPI;

public class RunnableDemo  implements Runnable {


    @Override
    public void run() {

        Thread t = Thread.currentThread();

        for (int i = 0; i < 5; i++) {
            System.out.println(t.getName() + "子线程RunnableDemo执行了" + i);
        }
    }
}
