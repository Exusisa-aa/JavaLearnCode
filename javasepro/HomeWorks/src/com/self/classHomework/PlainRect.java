package com.self.classHomework;

import java.util.Scanner;

public class PlainRect extends Rect{
    private double startX;
    private double startY;

    public PlainRect(double length, double width, double startX, double startY) {
        super(length, width);
        this.startX = startX;
        this.startY = startY;
    }

    public PlainRect() {
        this(0,0,0,0);
    }

    public boolean isInside(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个点的x坐标");
        double x = sc.nextDouble();
        System.out.println("请输入一个点的y坐标");
        double y = sc.nextDouble();
        if(x > this.startX && x < this.startX + super.length && y > this.startY && y < this.startY + super.width) {
            return true;
        }
        return false;
    }

    public void printFo(){
        System.out.println("长:" + super.length + " 宽:" + super.width);
        System.out.println("该矩形左上角的坐标为：" + this.startX + " " + this.startY);
    }
}
