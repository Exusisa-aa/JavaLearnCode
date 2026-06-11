package com.self.cinema.CustomerManage.ChatWithFriend;

import com.self.cinema.CustomerManage.CinemaCustomerManagement;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.Scanner;

public class ClientForChat {
    //TCP客户端
    public static void startClient(InetAddress friendIP){
        CinemaCustomerManagement.flushIOAndLog();
        try(
                Socket socket = new Socket()
        ) {
            socket.connect(new InetSocketAddress(friendIP, 4567),12000);
            try(
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os)
            ) {
                Scanner sc = new Scanner(System.in);
                while(true){
                    String rs = sc.nextLine();
                    dos.writeUTF(rs);
                    System.out.println("------------------");
                    if(Objects.equals(rs, "exit")){
                        socket.close();
                        System.out.println("客户端已退出~");
                        ServerForChat.dis.close();
                        break;
                    }
                }
            }catch (SocketTimeoutException e){
                e.getStackTrace();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
