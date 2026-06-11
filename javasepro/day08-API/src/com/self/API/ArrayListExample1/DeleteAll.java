package com.self.API.ArrayListExample1;

import java.util.ArrayList;

public class DeleteAll {
    public static void main(String[] args) {
        //        方法一
        ArrayList<String> shoppingCar1 = new ArrayList<>();
        shoppingCar1.add("枸杞");
        shoppingCar1.add("java入门");
        shoppingCar1.add("宁夏枸杞");
        shoppingCar1.add("黑枸杞");
        shoppingCar1.add("人字拖");
        shoppingCar1.add("特级枸杞");
        shoppingCar1.add("枸杞子");
        System.out.println(shoppingCar1);
        for (int i = 0; i < shoppingCar1.size(); i++) {
            if(shoppingCar1.get(i).contains("枸杞")){
                shoppingCar1.remove(shoppingCar1.get(i));
                i--;
            }
        }
        System.out.println(shoppingCar1);

//        方法二
        ArrayList<String> shoppingCar2 = new ArrayList<>();
        shoppingCar2.add("枸杞");
        shoppingCar2.add("java入门");
        shoppingCar2.add("宁夏枸杞");
        shoppingCar2.add("黑枸杞");
        shoppingCar2.add("人字拖");
        shoppingCar2.add("特级枸杞");
        shoppingCar2.add("枸杞子");
        System.out.println(shoppingCar2);
        for (int i = shoppingCar2.size() - 1; i >= 0; i--) {
            if(shoppingCar2.get(i).contains("枸杞")){
                shoppingCar2.remove(shoppingCar2.get(i));
            }
        }
        System.out.println(shoppingCar2);
    }
}
