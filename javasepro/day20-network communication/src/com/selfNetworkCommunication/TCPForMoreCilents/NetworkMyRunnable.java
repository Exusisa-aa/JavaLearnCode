package com.selfNetworkCommunication.TCPForMoreCilents;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class NetworkMyRunnable implements Runnable{
    private final Socket socket;

    public NetworkMyRunnable(Socket socket){
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
                    System.out.println(socket.getRemoteSocketAddress() + ":" + dis.readUTF());
                } catch (IOException e) {
                    System.out.println(socket.getRemoteSocketAddress() + "已断开");
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
