package com.self.CollectionsFramework.Map.MapErgodic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<String> date = new ArrayList<>();
        String[] site = {"A", "B", "C", "D"};

        for (int i = 1; i <= 80; i++) {
            date.add(site[r.nextInt(4)]);
        }
        System.out.println(date);


        Map<String,Integer> dates = new HashMap<>();
        for (String s : date) {
            if(dates.containsKey(s)){
                dates.put(s,dates.get(s) + 1);
            }else {
                dates.put(s,1);
            }
        }

        dates.forEach((k,v) -> System.out.println(k+":"+v));
    }
}
