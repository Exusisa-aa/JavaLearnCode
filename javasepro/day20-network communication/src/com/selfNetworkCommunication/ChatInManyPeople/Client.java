package com.selfNetworkCommunication.ChatInManyPeople;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        System.out.println("客户端已启动~");
        try(
                Socket socket = new Socket(InetAddress.getLocalHost(),4567);//每个客户端只有一条socket管道用来接收与发送消息，所有关闭时也只能监视自己的情况
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os)
        ) {
            Scanner sc = new Scanner(System.in);
            Runnable runnable = new ClientMyRunnable(socket);
            Thread thread = new Thread(runnable);
            thread.start();
            while(true){
                System.out.println("请输入：");
                String rs = sc.nextLine();

                if(Objects.equals(rs, "exit")){
                    System.out.println("客户端已退出~");
                    break;
                }

                dos.writeUTF(rs);
            }

        }catch (Exception e){
            e.getStackTrace();
        }


    }
}
