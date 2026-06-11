package com.self.Multithreading.MultithreadingCommunicationFor3;

public class MyRunnable implements Runnable{
    Desk desk;

    public MyRunnable(Desk desk){
        this.desk = desk;
    }
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        while (true) {
            if (t.getName().contains("厨师")){
                desk.add(t);
            }

            if (t.getName().contains("顾客")){
                desk.eat(t);
            }
        }
    }
}
