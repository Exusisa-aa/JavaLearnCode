package com.selfNetworkCommunication.UDPForMany;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try (
                //创建一个客户端对象
                DatagramSocket ds = new DatagramSocket()
        ) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                //创建一个包作为发送容器，以字节数组为容器，指定目的ip地址与端口
                byte[] bt;
                System.out.println("请输入：");
                String rs = sc.next();
                bt = rs.getBytes();
                DatagramPacket dp = new DatagramPacket(bt,bt.length,InetAddress.getLocalHost(),5678);

                if (Objects.equals(rs, "exit")){
                    break;
                }

                //发送
                ds.send(dp);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
