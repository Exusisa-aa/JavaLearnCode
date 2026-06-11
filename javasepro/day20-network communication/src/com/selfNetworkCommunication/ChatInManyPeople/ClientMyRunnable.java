package com.selfNetworkCommunication.ChatInManyPeople;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientMyRunnable implements Runnable{
    private final Socket socket;

    public ClientMyRunnable(Socket socket){
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
                    System.out.println(socket.getRemoteSocketAddress() + ":" + message);

                } catch (IOException e) {
                    System.out.println("自己已断开");//由于从集合中移除，故read无法在接受消息，只有存活的socket才能收消息
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
