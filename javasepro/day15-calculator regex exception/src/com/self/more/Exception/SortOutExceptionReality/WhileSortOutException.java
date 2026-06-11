package com.self.more.Exception.SortOutExceptionReality;

import java.util.Scanner;

public class WhileSortOutException {
    public static void main(String[] args) {
        while (true) {
            try {
                price();
                break;
            } catch (Exception e) {
                System.out.println("只能输入数字!!");
            }
        }

        while (true) {
            try {
                age();
                break;
            } catch (Exception e) {
                System.out.println("输入有误！");
            }
        }

    }

    public static void price(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入价格：");
            double price = sc.nextDouble();
            if(price > 0){
                System.out.println("价格正确");
                break;
            }else {
                System.out.println("价格错误");
            }
        }
    }

    public static void age(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入年龄：");
            double age = sc.nextDouble();
            if(age > 0){
                System.out.println("年龄正确");
                break;
            }else {
                System.out.println("年龄错误");
            }
        }
    }
}
