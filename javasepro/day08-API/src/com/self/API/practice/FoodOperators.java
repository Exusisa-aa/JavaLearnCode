package com.self.API.practice;
import java.util.Scanner;
import java.util.ArrayList;

public class FoodOperators {
    private Food food = new Food();
    private ArrayList<Food> uploads = new ArrayList<>();

    public  FoodOperators(){

    }

    public FoodOperators(Food food){
        this.food = food;
    }

    public void upload(){
        Food f = new Food();
        uploads.add(f);
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入菜品名字：");
        f.setName(sc.next());
        System.out.print("请输入菜品描述：");
        f.setDiscription(sc.next());
        System.out.print("请输入菜品价格：");
        f.setPrice(sc.nextDouble());
        System.out.println("上架成功");
    }

    public void visitAll(){
        if(uploads.size() == 0){
            System.out.println("您还未上架菜品，请前往上架");
            return;
        }

        for (int i = 0; i < uploads.size(); i++) {
            System.out.println((i + 1 + "，"));
            System.out.println(uploads.get(i).getName());
            System.out.println(uploads.get(i).getDiscription());
            System.out.println(uploads.get(i).getPrice());
            System.out.println("-------------------------------");
        }
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("---------------------------外卖界面-------------------------------");
            System.out.println("1.上架菜品");
            System.out.println("2.浏览所有菜品");
            System.out.println("3.退出");
            System.out.print("请输入指令：");
            switch (sc.next()){
                case "1" :
                    upload();
                    break;
                case "2" :
                    visitAll();
                    break;
                case "3" :
                    System.out.println("欢迎再来哦~~");
                    return;
                default:
                    System.out.println("您输入的指令有误！");
                    break;
            }
        }
    }

}
