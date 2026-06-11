package com.self.Multithreading.MultithreadingCommunicationFor12;

import java.util.ArrayList;
import java.util.List;


public class Desk {
    private List<String> desk = new ArrayList<>();

    public synchronized void add(Thread t){
        try {
            if (desk.isEmpty()) {
                desk.add(t.getName() + "做的一个包子");
                System.out.println(desk.get(0));
                Thread.sleep(10);
            }
            this.notifyAll();
            this.wait();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void eat(Thread t){
        try {
            if (!desk.isEmpty()) {
                System.out.println(t.getName() + "吃了" + desk.get(0));
                desk.remove(0);
                Thread.sleep(10);
            }
                this.notifyAll();
                this.wait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
