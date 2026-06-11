package com.self.Multithreading.MultithreadingProblemSolution1;

public class Test {
    public static void main(String[] args) {

        Account account1 = new Account("小小一家",100000);

        MyRunnable myRunnable1 = new MyRunnable(account1);
        Thread t1 = new Thread(myRunnable1,"小红");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(myRunnable1,"小明");
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------");

        Account account2 = new Account("大大一家",100000);

        MyRunnable myRunnable2 = new MyRunnable(account2);

        Thread t3 = new Thread(myRunnable2,"大白");
        t3.start();

        Thread t4 = new Thread(myRunnable2,"大黑");
        t4.start();
    }

}

