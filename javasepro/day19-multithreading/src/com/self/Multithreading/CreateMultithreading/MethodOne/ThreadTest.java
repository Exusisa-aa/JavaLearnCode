package com.self.Multithreading.CreateMultithreading.MethodOne;

public class ThreadTest {
    public static void main(String[] args) {
        Thread myThread = new MyThread("线程1");
        myThread.start();//启动线程一定是start方法  否则不是多线程

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程Main执行了" + i);
            //主线程一定要在单线程之后，否则不是多线程.
        }
    }
}
