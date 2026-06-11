package com.self.oop_pro.Enum.EnumMention;

public enum A {
    //枚举都是最终类不能被继承
    //public final class A extends java.lang.Enum<A>
    //第一行要写对象的名字，且都是常量,用的是无参构造器
    X("小明"),Y,Z;
    //public static final A X/Y/Z = new A();
    //构造器私有不能创建对象
    private String name;

    A(String name) {
        this.name = name;
    }

    A() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
