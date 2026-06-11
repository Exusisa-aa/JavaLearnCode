package com.self.cinema.StartCustomer;


public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            StartCustomer.proxyForCustomer.startSystemForCustomer();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
