package com.selfNetworkCommunication.UDPForOne;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args){
        try (
                //创建一个客户端对象
                DatagramSocket ds = new DatagramSocket(9999)
        ) {
            //创建一个包作为发送容器，以字节数组为容器，指定目的ip地址与端口
            byte[] bt;
            bt = "发送了一个包".getBytes();
            DatagramPacket dp = new DatagramPacket(bt,bt.length,InetAddress.getLocalHost(),6666);

            //发送
            ds.send(dp);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
