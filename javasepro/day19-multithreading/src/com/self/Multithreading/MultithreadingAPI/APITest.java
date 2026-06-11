package com.self.Multithreading.MultithreadingAPI;

public class APITest {
    public static void main(String[] args) throws InterruptedException {
        RunnableDemo r1 = new RunnableDemo();
        Thread t1 = new Thread(r1, "线程1");
//        t1.setName("线程1");
        t1.start();
        t1.join();//用于启动线程后 可先执行某个线程

        RunnableDemo r2 = new RunnableDemo();
        Thread t2 = new Thread(r2,"线程2");
//        t2.setName("线程2");
        t2.start();


        Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(t.getName() + "主线程main执行了" + i);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
