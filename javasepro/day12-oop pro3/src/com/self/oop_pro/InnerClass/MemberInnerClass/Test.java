package com.self.oop_pro.InnerClass.MemberInnerClass;

public class Test {
    public static void main(String[] args) {
        Car.Engine s = new Car().new Engine();//该对象用于访问内部类
        Car b = new Car();//该对象用于访问外部类
        s.run();
        b.run();
        s.print();
    }

}
