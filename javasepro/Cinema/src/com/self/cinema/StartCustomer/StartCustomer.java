package com.self.cinema.StartCustomer;

import com.self.cinema.CustomerManage.CinemaCustomerManagement;
import com.self.cinema.CustomerManage.ProxyForWorker.CinemaForCustomer;
import com.self.cinema.CustomerManage.ProxyForWorker.ProxyForCustomer;

import java.util.concurrent.*;

public class StartCustomer {
    //CinemaCustomerManagement 的动态代理
    public static CinemaCustomerManagement cinemaCustomerManagement = new CinemaCustomerManagement();
    public static CinemaForCustomer proxyForCustomer = ProxyForCustomer.createProxy(cinemaCustomerManagement);


    public static void main(String[] args) {
        //用户系统支持多线程
        ExecutorService esForCustomer = new ThreadPoolExecutor(40,50
                ,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        esForCustomer.execute(new MyRunnable());






    }
}
