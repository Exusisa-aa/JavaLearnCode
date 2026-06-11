package com.self.CollectionsFramework.Map.MapErgodic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapErgodicDemo {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("小陈",168.5);
        map.put("小红",173.8);
        map.put("小张",180.6);
        map.put("小迪",173.1);
        map.put("小明",190.2);
        //1.键找值
        Set<String> set = map.keySet();
        for (String key : set) {
            double value = map.get(key);
            System.out.println(key + "-->" + value);
        }
        System.out.println("--------------------------");

        //2.键值对
        Set<Map.Entry<String,Double>> entries = map.entrySet();//封装为键值对对象
        for (Map.Entry<String,Double> entry : entries) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.println(key + "--->" + value);
        }
        System.out.println("--------------------------");
        //3.Lambda

//        map.forEach(new BiConsumer<String, Double>() {
//            @Override
//            public void accept(String k, Double v) {
//                System.out.println(k + "---->" + v);
//            }
//        });

        map.forEach((k,v) -> System.out.println(k + "--->" + v));

    }
}
