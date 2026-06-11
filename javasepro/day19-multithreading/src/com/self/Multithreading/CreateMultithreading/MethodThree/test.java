package com.self.Multithreading.CreateMultithreading.MethodThree;

public class test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("字线程MyRunnable执行了" + i);
                }
            }
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程Main执行了" + i);
            //主线程一定要在单线程之后，否则不是多线程.
        }
    }
}
