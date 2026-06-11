package com.selfNetworkCommunication.ChatInManyPeople;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final List<Socket> socketList = new ArrayList<>(); //所有在线socket
    public static void main(String[] args) {
        System.out.println("服务端已启动~");
        try(
                ServerSocket serverSocket = new ServerSocket(4567)
        ){
            while (true){
                //多线程处理多条socket管道，故结束的时候可以监测每条客户端的情况
                Socket socket = serverSocket.accept();
                socketList.add(socket);
                Runnable runnable = new ServerMyRunnable(socket);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
