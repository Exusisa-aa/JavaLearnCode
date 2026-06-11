package com.slef.examples;
import java.util.Scanner;
public class HomeWorkDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程名称：");
        String classes = sc.next();
        System.out.println("请输入课程的学时：");
        int hours = sc.nextInt();
        System.out.println("请输入使用的教材：");
        String books = sc.next();
        System.out.println("请输入出版日期：");
        String date = sc.next();
        System.out.println("请输入价格：");
        double price = sc.nextDouble();

        print(classes,hours,books,date,price);
    }

    public static void print(String classes,int hours,String books,String date,double price){
        System.out.println(classes + "课程使用" + date + "出版的《" + books + "》教材" + "总学时数为：" + hours);
        System.out.println("《" + books + "》" + "教材的价格为：" + price);
    }
}
