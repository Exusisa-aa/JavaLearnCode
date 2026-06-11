package com.self.processcontroller;
import java.util.Scanner;
public class SwitchBranchDemo1 {
    public static void main(String[] args) {
        //switch的使用方法
        /*
        周一：埋头苦干，解决bug            周二：请求大牛程序员帮忙          周三：今晚瓶啤、龙虾、小烧烤
        周四：主动帮助新来的女程序员解决bug   周五：今晚lol                  周六：相亲
        周天/日：郁郁寡欢，准备上班
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的星期信息：");
        String week =sc.next();
        switch (week) {
            case "周一" :
                System.out.println("埋头苦干，解决bug");
                break;
            case "周二" :
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周三" :
                System.out.println("今晚啤酒、烧烤、小龙虾");
                break;
            case "周四" :
                System.out.println("主动帮助新来的女程序员解决b");
                break;
            case "周五" :
                System.out.println("今晚lol ");
                break;
            case "周六" :
                System.out.println("相亲");
                break;
            case "周天" :
            case "周日" :
                System.out.println("郁郁寡欢，准备上班");
                break;
            default:
                System.out.println("您输入的星期信息有误，请重新输入~~");
        }
        System.out.println("祝您一周过得愉快~~");
    }
}
