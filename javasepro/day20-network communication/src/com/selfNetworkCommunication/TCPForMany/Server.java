package com.selfNetworkCommunication.TCPForMany;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务端已启动~");
        try(
                ServerSocket serverSocket = new ServerSocket(4567);
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is)
        ){
            while (true){
                try {
                    System.out.println("-------------------");
                    System.out.println(socket.getRemoteSocketAddress() + ":" +dis.readUTF());
                } catch (IOException e) {
                    System.out.println(socket.getRemoteSocketAddress() + "已断开");
                    break;
                }
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
