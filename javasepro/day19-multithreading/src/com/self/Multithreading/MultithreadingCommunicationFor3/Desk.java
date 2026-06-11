package com.self.Multithreading.MultithreadingCommunicationFor3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Desk {
    private List<String> desk = new ArrayList<>();
    private final Lock lk = new ReentrantLock();
    Condition condition = lk.newCondition();

    public void add(Thread t){
        try {
            lk.lock();
            if (desk.isEmpty()) {
                desk.add(t.getName() + "做的一个包子");
                System.out.println(desk.get(0));
                Thread.sleep(10);
            }
                condition.signalAll();
                condition.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lk.unlock();
        }
    }

    public void eat(Thread t){
        try {
            lk.lock();
            if (!desk.isEmpty()) {
                System.out.println(t.getName() + "吃了" + desk.get(0));
                desk.remove(0);
                Thread.sleep(10);
            }
                condition.signalAll();
                condition.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lk.unlock();
        }
    }
}
