package src.com.self;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<Card> cards = new ArrayList<>();


    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String check;
        while (flag) {
            System.out.println("=====================游戏==================");
            System.out.println("1.开始游戏");
            System.out.println("2.退出");
            System.out.print("请输入命令：");
            switch (sc.next()){
                case "1":
                    randomCards(cards);
                    while (true){
                        System.out.println(" ");
                        System.out.println("是否开始游戏？y/n");
                        check = sc.next();
                        if(Objects.equals(check,"n")){
                            ArrayList<Card> card= new ArrayList<>();
                            randomCards(card);
                            cards = card;
                        }else if(Objects.equals(check,"y")){
                            System.out.println("我要挑战计算");
                            calculate(cards);
                            break;
                        }else {
                            System.out.println("您输入指令有误，请重新输入：");
                        }
                    }
                case "2":
                    return;
                default:
                    System.out.print("您输入的命令有误，请重新输入：");
                    flag = false;
                    break;
            }
        }
    }
    public void randomCards(ArrayList<Card> cards){
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            Card card = new Card();
            cards.add(card);
            Integer number = r.nextInt(13)+1;
            cards.get(i).setNumber(number);
            System.out.print("牌" + (i + 1) + "为：" + cards.get(i).getNumber() + "\t");
        }
        System.out.println(" ");
        for (int i = 4; i < 7; i++) {
            Card card = new Card();
            cards.add(card);
            cards.get(i).setNumber(0);
            System.out.print("和" + (i - 3) + "为：" + cards.get(i).getNumber() + "\t");
        }
    }

    public void calculate(ArrayList<Card> card){
        Scanner sc = new Scanner(System.in);
        int time = 1;
        while (time <= 3) {
            int remember1 = 0;
            int remember2 = 0;
            int left = 0;
            int right = 0;
            ArrayList<Object> sz = new ArrayList<>();
            System.out.println(" ");
            System.out.println("第" + time + "次计算：");
            while (true) {
                try {
                    inputInteger(sz,1);
                    break;
                } catch (Exception e) {
                    System.out.println("只能输入数字哦~~");
                }
            }


            while (true) {
                System.out.print("输入第符号位数：");
                String symbol = sc.next();
                if(Objects.equals(symbol,"+") || Objects.equals(symbol,"-") || Objects.equals(symbol,"*") || Objects.equals(symbol,"/")){
                    sz.add(symbol);
                    break;
                }else {
                    System.out.println("仅仅能输入+ - * / 哦~~");
                }
            }


            while (true) {
                try {
                    inputInteger(sz,2);
                    break;
                } catch (Exception e) {
                    System.out.println("只能输入数字哦~~");
                }
            }
            for (int j = 4; j < 7; j++) {
                if (sz.get(0).equals(card.get(j).getNumber())) {
                    left = card.get(j).getNumber();
                    card.get(j).setNumber(0);
                    remember1 = j;
                    break;
                }
            }

            for (int j = 4; j < 7; j++) {
                if(sz.get(2).equals(card.get(j).getNumber())){
                    right = card.get(j).getNumber();
                    card.get(j).setNumber(0);
                    remember2 = j;
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if(sz.get(2).equals(card.get(j).getNumber())){
                    right = card.get(j).getNumber();
                    card.get(j).setNumber(0);
                    remember2 = j;
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if (sz.get(0).equals(card.get(j).getNumber())) {
                    left = card.get(j).getNumber();
                    card.get(j).setNumber(0);
                    remember1 = j;
                    break;
                }
            }

            if(left == 0 && right == 0){
                System.out.println("没有该数字，请重新输入：");
            } else if(left == 0 || right == 0){
                if(left == 0){
                    card.get(remember2).setNumber(right);
                } else {
                    card.get(remember1).setNumber(left);
                }
                System.out.println("没有该数字，请重新输入：");
            } else if(Objects.equals(sz.get(1).toString().charAt(0),'+')){
                card.get(time+3).setNumber(left+right);
                time++;
            } else if(Objects.equals(sz.get(1).toString().charAt(0),'-')){
                card.get(time+3).setNumber(left-right);
                time++;
            } else if(Objects.equals(sz.get(1).toString().charAt(0),'*')){
                card.get(time+3).setNumber(left*right);
                time++;
            } else if(Objects.equals(sz.get(1).toString().charAt(0),'/')){
                card.get(time+3).setNumber(left/right);
                time++;
            }
            for (int i = 0; i < 4; i++) {
                System.out.print("牌" + (i + 1) + "为：" + card.get(i).getNumber() + "\t");
            }
            System.out.println(" ");
            for (int i = 4; i < 7; i++) {
                System.out.print("和" + (i - 3) + "为：" + card.get(i).getNumber() + "\t");
            }
            if(card.get(5).getNumber() == 24 && card.get(0).getNumber() == 0 && card.get(1).getNumber() == 0 && card.get(2).getNumber() == 0 && card.get(3).getNumber() == 0) {
                System.out.println("恭喜你，计算成功");
                return;
            }
            if(card.get(4).getNumber() == 24 && card.get(0).getNumber() == 0 && card.get(1).getNumber() == 0 && card.get(2).getNumber() == 0 && card.get(3).getNumber() == 0) {
                System.out.println("恭喜你，计算成功");
                return;
            }
        }
        if(card.get(6).getNumber() == 24){
            System.out.println("恭喜你，计算成功");
        }else {
            System.out.println("计算失败,请重新开始");
            start();
        }

    }


    public void inputInteger(ArrayList<Object> sz,int time){
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("输入第" + time + "位数：");
            number = sc.nextInt();
            if(number == 0){
                System.out.println("您不能输入0");
            }else {
                sz.add(number);
                break;
            }
        }
    }
}
