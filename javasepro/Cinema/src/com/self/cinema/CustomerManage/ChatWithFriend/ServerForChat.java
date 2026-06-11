package com.self.cinema.CustomerManage.ChatWithFriend;

import com.self.cinema.CustomerManage.CinemaCustomerManagement;
import com.self.cinema.CustomerManage.Customer.Customer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ServerForChat {
    //TCP服务端
    public static DataInputStream dis = null;

    public static void startServer() {
        CinemaCustomerManagement.flushIOAndLog();
        var ref = new Object() {
            Thread thread = null;
        };

        ref.thread = new Thread(() -> {
            String name = "";
            int timeOut = 12000;//超时时间
            final int[] count = {0};//执行次数
            int timePeriod  = 4000;//执行周期

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    count[0]++;
                    System.out.println("等待上线中~~");
                    if(count[0] == timeOut/timePeriod){
                        timer.cancel();
                    }
                }
            };
            timer.schedule(task,0,timePeriod);
            try(
                    ServerSocket serverSocket = new ServerSocket(4567)
            ){
                serverSocket.setSoTimeout(timeOut);
                try(
                        Socket socket = serverSocket.accept();
                        InputStream is = socket.getInputStream()
                ) {
                    ServerForChat.dis = new DataInputStream(is);
                    timer.cancel();
                    System.out.println("对方已上线~~");
                    while (true){
                        try {
                            System.out.println("-------------------");
                            for (Customer customer : CinemaCustomerManagement.customers) {
                                if(Objects.equals(customer.getIp().toString(),socket.getInetAddress().toString())){
                                    name = customer.getName();
                                }
                            }
                            System.out.println(name + ":" +dis.readUTF());
                        } catch (IOException e) {
                            System.out.println(name + "已断开");
                            ref.thread.interrupt();
                            return;
                        }
                    }
                }catch (Exception e){
                    System.out.println("十秒钟对方未连接,已自动退出~~");
                    serverSocket.close();
                }
            }catch (Exception e){
                e.getStackTrace();
            }
        });
        ref.thread.start();
    }




}
