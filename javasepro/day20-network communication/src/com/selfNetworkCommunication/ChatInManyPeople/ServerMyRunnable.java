package com.selfNetworkCommunication.ChatInManyPeople;

import java.io.*;
import java.net.Socket;

public class ServerMyRunnable implements Runnable{
    private final Socket socket;


    public ServerMyRunnable(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try(
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is)
        ) {
            while (true){
                try {
                    String message = dis.readUTF();
                    sendMessage(message);
                    System.out.println(socket.getInetAddress() + ":" + message);
                } catch (IOException e) {
                    System.out.println(socket.getRemoteSocketAddress() + "已断开"); //各个socket线程监视自己的情况
                    Server.socketList.remove(socket);
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void sendMessage(String message){
        try{
            for (Socket socket1 : Server.socketList) {
                OutputStream os = socket1.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(message);
                dos.flush();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
