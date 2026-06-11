package com.self.CollectionsFramework.Map.MapBasis;

import java.util.*;

public class MapBasisDemo {
    public static void main(String[] args) {
        //1.创建集合
        Map<String,Integer> map1 = new HashMap<>();
        System.out.println("------------------------------");
        //2.添加元素
        map1.put("手表",20);
        map1.put("手表",2000);
        map1.put("手机",10);
        map1.put("java",60);
        map1.put(null,null);
        System.out.println(map1);
        System.out.println("------------------------------");
        //3.获取长度
        System.out.println(map1.size());
        System.out.println("------------------------------");
        //4.清空集合
//        map1.clear();
        System.out.println(map1);
        System.out.println("------------------------------");
        //5.判断是否为空
        System.out.println(map1.isEmpty());
        System.out.println("------------------------------");
        //6.根据键获取对应的值
        System.out.println(map1.get("java"));
        System.out.println(map1.get("Java"));
        System.out.println(map1.get("手表"));
        System.out.println(map1.get(null));
        System.out.println("------------------------------");
        //7.根据值删除某个元素
        map1.remove(null);
        map1.remove("java");
        map1.remove("Java");
        System.out.println(map1);
        System.out.println("------------------------------");
        //8.判断是否包含某个键
        System.out.println(map1.containsKey("java"));
        System.out.println(map1.containsKey("手表"));
        System.out.println("------------------------------");
        //9.判断是否包含某个值
        System.out.println(map1.containsValue(20));
        System.out.println(map1.containsValue("20"));
        System.out.println(map1.containsValue(2000));
        System.out.println("------------------------------");
        //10.map的键转为set集合
        Set<String> set = map1.keySet();
        System.out.println(set);
        System.out.println("------------------------------");
        //11.map的值转为collection集合
        Collection<Integer> collection = map1.values();
        System.out.println(collection);
        System.out.println("------------------------------");
        //12.添加某个map的所有值
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("手表",20000);
        map2.put("java",0);
        map1.putAll(map2);
        System.out.println(map1);
        System.out.println("------------------------------");

    }

}
