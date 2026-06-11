package com.self.cinema.StartWorker;


import com.self.cinema.WorkerManage.CinemaWorkerManagement;
import com.self.cinema.WorkerManage.ProxyForManage.CinemaForWorker;
import com.self.cinema.WorkerManage.ProxyForManage.ProxyForWorker;


import java.util.concurrent.*;

public class StartWorker {
    //CinemaWorkerManagement 的动态代理
    public static CinemaWorkerManagement cinemaWorkerManagement = new CinemaWorkerManagement();
    public static CinemaForWorker proxyForWorker = ProxyForWorker.createProxy(cinemaWorkerManagement);
    public static void main(String[] args) {
        //工作人员系统支持多线程
        ExecutorService esForWorker = new ThreadPoolExecutor(40,50
                                                    ,10, TimeUnit.SECONDS,
                                                    new ArrayBlockingQueue<>(20),
                                                    Executors.defaultThreadFactory(),
                                                    new ThreadPoolExecutor.AbortPolicy());

        esForWorker.execute(new MyRunnable());






    }
}
