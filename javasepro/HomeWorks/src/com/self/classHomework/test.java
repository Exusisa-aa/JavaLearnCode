package com.self.classHomework;

public class test {
    public static void main(String[] args) {
        PlainRect pr = new PlainRect(20,10,10,10);
        System.out.println("面积为：" + pr.area());
        System.out.println("周长为" + pr.perimeter());
        if(pr.isInside()){
            System.out.println("点在矩形里");
            pr.printFo();
        }else {
            System.out.println("点不在矩形里");
            pr.printFo();
        }
    }
}
