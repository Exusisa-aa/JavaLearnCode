package com.slef.examples;
import java.util.Scanner;
public class PlaneTickersDemo {
    //买飞机票有淡季和旺季的区分，5-10月为旺季，头等舱9折，经济舱8.5折，11-4月为淡季，头等舱7折，经济舱7.5折，请计算出优惠价格
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入票价：");
        double price = sc.nextDouble();
        price(price);
    }


    public static void price(double a){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入月份：");
            int month = sc.nextInt();
            if(month >= 13 || month <= 0){
                System.out.println("您输入的月份有误，请重新输入：");
            }else if (month <= 10 && month >= 5) {
                System.out.println("该月份为旺季");
                double head = a*0.9;
                double economy = a*0.85;
                while (true){
                    System.out.println("请输入所选的舱类：");
                    String flight =sc.next();
                    switch (flight){
                        case "头等舱":
                            System.out.println("头等舱的票价为：" + head);
                            System.out.println("祝您乘坐愉快~~");
                            return;
                        case "经济舱":
                            System.out.println("经济舱的票价为：" + economy);
                            System.out.println("祝您乘坐愉快~~");
                            return;
                        default:
                            System.out.println("您输入的舱位有误，请重新输入：");
                    }
                }
            }else if(month >= 11 || month <= 4){
                System.out.println("该月份为淡季");
                double head = a*0.7;
                double economy = a*0.75;
                while (true){
                    System.out.println("请输入所选的舱类：");
                    String flight =sc.next();
                    switch (flight){
                        case "头等舱":
                            System.out.println("头等舱的票价为：" + head);
                            System.out.println("祝您乘坐愉快~~");
                            return;
                        case "经济舱":
                            System.out.println("经济舱的票价为：" + economy);
                            System.out.println("祝您乘坐愉快~~");
                            return;
                        default:
                            System.out.println("您输入的舱位有误，请重新输入：");
                    }
                }
            }
        }
    }
}
