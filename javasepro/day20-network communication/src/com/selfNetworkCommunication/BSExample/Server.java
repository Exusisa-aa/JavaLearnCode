package com.selfNetworkCommunication.BSExample;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务端已启动");
        try(
                ServerSocket ss = new ServerSocket(8080)
        ) {
            ExecutorService es = new ThreadPoolExecutor(40,40,0,
                    TimeUnit.SECONDS,new ArrayBlockingQueue<>(20),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
            while (true) {
                Socket socket = ss.accept();
                System.out.println("网页已上线~~");
                Runnable serverRunnable = new ServerRunnable(socket);
                es.execute(serverRunnable);
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
