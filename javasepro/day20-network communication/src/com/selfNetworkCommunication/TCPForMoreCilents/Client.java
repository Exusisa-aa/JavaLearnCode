package com.selfNetworkCommunication.TCPForMoreCilents;

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
                Socket socket = new Socket(InetAddress.getLocalHost(),4567);
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os)
        ) {
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("请输入：");
                String rs = sc.nextLine();

                if(Objects.equals(rs, "exit")){
                    System.out.println("客户端已退出~");
                    break;
                }

                dos.writeUTF(rs);
                System.out.println("------------------");
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
