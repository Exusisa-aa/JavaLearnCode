package com.selfNetworkCommunication.TCPForMany;

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
                dos.writeUTF(rs);
                System.out.println("------------------");
                if(Objects.equals(rs, "exit")){
                    socket.close();
                    System.out.println("客户端已退出~");
                    break;
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
