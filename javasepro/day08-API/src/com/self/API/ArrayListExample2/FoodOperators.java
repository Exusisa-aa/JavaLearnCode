package com.self.API.ArrayListExample2;
import java.util.Scanner;
import java.util.ArrayList;

public class FoodOperators {
    private Food food = new Food();
    private ArrayList<Food> load = new ArrayList<>();

    public FoodOperators(){

    }

    public FoodOperators(Food food){
        this.food = food;
    }

    public void upload(){
        Food f = new Food();
        load.add(f);
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入菜品名称:");
        f.setName(sc.next());
        System.out.print("请输入菜品描述:");
        f.setDescription(sc.next());
        System.out.print("请输入菜品价格:");
        f.setPrice(sc.next());
        System.out.println("上架完成");
    }

    public void visitInformation(){
        if(load.size() == 0){
            System.out.println("您还未上架商品,请前往上架");
            return;
        }
        for (int i = 0; i < load.size(); i++) {
                System.out.println((i + 1 + "."));
                System.out.println(load.get(i).getName());
                System.out.println(load.get(i).getDescription());
                System.out.println(load.get(i).getPrice());
                System.out.println("------------------------------");
        }
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------外卖界面----------------");
            System.out.println("1.上架商品");
            System.out.println("2.产看商品信息");
            System.out.println("3.退出");
            System.out.print("请输入指令：");
            switch (sc.next()){
                case "1" :
                    upload();
                    break;
                case "2" :
                    visitInformation();
                    break;
                case "3" :
                    System.out.println("下次再来哦");
                    return;
                default :
                    System.out.println("您输入的命令不存在！");
                    break;
            }
        }
    }
}
