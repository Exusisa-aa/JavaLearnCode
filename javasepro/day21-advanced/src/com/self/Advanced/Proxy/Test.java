package com.self.Advanced.Proxy;


public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("zzz");
        Star p = ProxyUtil.createProxy(bigStar);
        System.out.println(p.sing("haha"));
        p.dance();
    }
}
