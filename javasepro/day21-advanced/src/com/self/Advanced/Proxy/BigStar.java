package com.self.Advanced.Proxy;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String song) {
        System.out.println(name + "正在唱" + song);
        return "谢谢！谢谢！";
    }

    @Override
    public void dance() {
        System.out.println(name + "正在跳舞");
    }
}
