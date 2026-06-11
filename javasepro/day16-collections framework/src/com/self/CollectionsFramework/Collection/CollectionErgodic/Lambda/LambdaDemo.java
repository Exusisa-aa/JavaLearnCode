package com.self.CollectionsFramework.Collection.CollectionErgodic.Lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class LambdaDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        c.add("F");


//        c.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });


//        c.forEach(s -> System.out.println(s));

        c.forEach(System.out::println);
    }
}
