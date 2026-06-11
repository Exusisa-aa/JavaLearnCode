package com.self.opp_pro.AbstractExample;

public class Text {
    public static void main(String[] args) {
        Animal c1 = new Cat("叮当猫");
        Animal d1 = new Dog("哈基米");
        c1.cry();
        d1.cry();

        cry(c1);
        cry(d1);
    }

    public static void cry(Animal a){
        if(a instanceof Cat){
            ((Cat)a).name1();
        } else if (a instanceof Dog) {
            ((Dog)a).name2();
        }
    }
}
