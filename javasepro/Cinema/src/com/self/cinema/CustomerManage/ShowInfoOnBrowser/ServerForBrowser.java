package com.self.cinema.CustomerManage.ShowInfoOnBrowser;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.*;

public class ServerForBrowser {
    public static void startServerForBrowser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("服务端已启动 10s倒计时");
        try(
                ServerSocket ss = new ServerSocket(8080)
        ) {
            ExecutorService es = new ThreadPoolExecutor(40,40,0,
                    TimeUnit.SECONDS,new ArrayBlockingQueue<>(20),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
            while (true) {
                ss.setSoTimeout(10000);
                Socket socket = ss.accept();
                Runnable serverRunnable = new ServerRunnable(socket);
                es.execute(serverRunnable);
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
