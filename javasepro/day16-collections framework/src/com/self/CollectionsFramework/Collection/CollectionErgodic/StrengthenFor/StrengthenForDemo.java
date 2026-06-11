package com.self.CollectionsFramework.Collection.CollectionErgodic.StrengthenFor;

import java.util.ArrayList;
import java.util.Collection;

public class StrengthenForDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");

        Integer[] array = {1,2,3,4,5};

        for (String s : c){
            System.out.println(s);
        }
        for (Integer i : array){
            System.out.println(i);
        }
    }
}
