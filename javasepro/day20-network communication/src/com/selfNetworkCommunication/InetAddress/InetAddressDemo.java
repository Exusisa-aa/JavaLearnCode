package com.selfNetworkCommunication.InetAddress;

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) throws Exception{
        InetAddress ia1 = InetAddress.getLocalHost();
        System.out.println(ia1.getHostName());
        System.out.println(ia1.getHostAddress());

        System.out.println("------------------------");

        InetAddress ia2 = InetAddress.getByName("www.bilibili.com");
        System.out.println(ia2.getHostName());
        System.out.println(ia2.getHostAddress());
        System.out.println(ia2.isReachable(6000));
    }
}
