package com.self.Multithreading.Example;

public class ExampleDemo {
    public static void main(String[] args) {
        MyRunnable MyRunnable = new MyRunnable();
        MyRunnable.addGift();

        Thread thread1 = new Thread(MyRunnable,"小明");
        Thread thread2 = new Thread(MyRunnable,"小红");

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("小红发了" + MyRunnable.getCount1() + "个礼物");
        System.out.println("小明发了" + MyRunnable.getCount2() + "个礼物");


    }
}
