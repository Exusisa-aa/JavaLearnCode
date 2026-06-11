package com.slef.examples;
import java.util.Scanner;
import java.util.Random;
public class GrabRedEnvelopesDemo {
    //一个大v发起了抢红包活动，分别有9,666,188,520,99999五个红包，模拟粉丝来抽奖，先到先得，随机抽取，抽完即止，
    public static void main(String[] args) {
        bag();//方案二
        raffle();//方案一
    }

    public static void raffle(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] money ={9,666,188,520,99999};
        for (int i = 0; i < money.length; i++) {
            while (true){
                int rr = r.nextInt(money.length);
                if(money[rr] != 0){
                    System.out.println("请输入随机键完成抽奖");
                    String r0 = sc.next();
                    System.out.println("恭喜您抢到了红包：" + money[rr]);
                    money[rr] = 0;
                    break;
                }
            }

        }
        System.out.println("活动已结束~~");
    }

    public static void bag(){
        Random r = new Random();
        int[] bags ={9,666,188,520,99999};
        for (int i = 0; i < bags.length; i++) {
            int rr = r.nextInt(bags.length);
            int temp = bags[i];
            bags[i] = bags[rr];
            bags[rr] = temp;
        }
        for (int i = 0; i < bags.length; i++) {
            System.out.println("第"+(i + 1) +"位粉丝的中奖结果为：" + bags[i]);
        }
    }
}
