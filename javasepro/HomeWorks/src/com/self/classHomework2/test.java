package com.self.classHomework2;

public class test {
    public static void callSound(Animal animal){
        System.out.println(animal.toString());
        animal.sound();
    }

    public static void callFly(Flyable flyable){
        flyable.fly();
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        Flyable cuckoo = new Cuckoo();

        test.callSound(cat);
        test.callFly(cuckoo);
    }
}
