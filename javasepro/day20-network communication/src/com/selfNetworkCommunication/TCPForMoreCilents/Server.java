package com.selfNetworkCommunication.TCPForMoreCilents;


import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务端已启动~");
        try(
                ServerSocket serverSocket = new ServerSocket(4567)
        ){
            while (true){
                Socket socket = serverSocket.accept();
                Runnable runnable = new NetworkMyRunnable(socket);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
