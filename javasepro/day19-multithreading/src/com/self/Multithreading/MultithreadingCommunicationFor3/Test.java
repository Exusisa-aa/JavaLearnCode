package com.self.Multithreading.MultithreadingCommunicationFor3;

public class Test {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Runnable MyRunnable = new MyRunnable(desk);

        Thread t1 = new Thread(MyRunnable,"厨师1");
        t1.start();
        Thread t2 = new Thread(MyRunnable,"厨师2");
        t2.start();
        Thread t3 = new Thread(MyRunnable,"厨师3");
        t3.start();
        Thread t4 = new Thread(MyRunnable,"顾客1");
        t4.start();
        Thread t5 = new Thread(MyRunnable,"顾客2");
        t5.start();

    }
}
