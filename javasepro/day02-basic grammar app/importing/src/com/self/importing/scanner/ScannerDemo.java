package com.self.importing.scanner;
import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int age = sc.nextInt();
        System.out.println("您的年龄是：" + age);
        System.out.println("请输入您的性别： （1为男性  2为女性）");
        int sex = sc.nextInt();
        if (sex != 1 && sex !=2) {
            System.out.println("您输入有误 请重新输入");
            int sex1 = sc.nextInt();
            if (sex1 != 1 && sex1 != 2){
                System.out.println("输入错误，请重新运行该程序");
            }
            System.out.println("请输入您的名字：");
            String name = sc.next();
            if (sex1 == 1){
                System.out.println(name + "先生，欢迎您进入系统");
            }else if(sex1 == 2){
                System.out.println(name + "女士，欢迎您进入系统");
            }
        }else{
            System.out.println("请输入您的名字");
            String name = sc.next();
            if (sex == 1){
                System.out.println(name + "先生，欢迎您进入系统");
            }else{
                System.out.println(name + "女士，欢迎您进入系统");
        }
            }
        }
}


