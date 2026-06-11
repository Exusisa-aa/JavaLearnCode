package com.selfNetworkCommunication.UDPForMany;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try(
                //创建一个服务端对象
                DatagramSocket ds = new DatagramSocket(5678)
        ) {
            //创建一个包对象，该对象需要字节数组作为容器,接收数据
            byte[] bt = new byte[1024 * 64];
            DatagramPacket dp = new DatagramPacket(bt,bt.length);

            //接收包
            while (true) {
                ds.receive(dp);

                String rs = new String(bt,0,dp.getLength());
                System.out.println(rs);
                System.out.println(dp.getLength());
                System.out.println(dp.getAddress().getHostAddress());
                System.out.println(dp.getPort());
                System.out.println("-----------------------");
            }


        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
