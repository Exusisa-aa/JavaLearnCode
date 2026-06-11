package com.self.Multithreading.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable{
    private AtomicInteger number = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "为" + number.incrementAndGet());
        }
    }
}
