package com.self.Multithreading.MultithreadingProblem;

public class Test {
    public static void main(String[] args) {

        Account account = new Account("线程安全示例",100000);

        MyRunnable myRunnable = new MyRunnable(account);
        Thread t1 = new Thread(myRunnable,"小红");
        t1.start();

        Thread t2 = new Thread(myRunnable,"小明");
        t2.start();
    }

}

