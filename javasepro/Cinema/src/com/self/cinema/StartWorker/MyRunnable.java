package com.self.cinema.StartWorker;



public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            StartWorker.proxyForWorker.startSystemForWorker();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
