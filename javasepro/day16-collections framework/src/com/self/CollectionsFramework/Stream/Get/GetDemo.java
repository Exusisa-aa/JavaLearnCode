package com.self.CollectionsFramework.Stream.Get;

import java.util.*;
import java.util.stream.Stream;

public class GetDemo {
    public static void main(String[] args) {
        //1.list
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "e", "f", "g", "h");
        Stream<String> s1 = list.stream();



        //2.set
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "a", "b", "c", "d", "e", "f", "g", "h");
        Stream<String> s2 = set.stream();


        //3.map
        Map<String, Double> map = new HashMap<>();
        map.put("a", 1.0);
        map.put("b", 2.0);
        map.put("c", 3.0);
        map.put("d", 4.0);
        map.put("e", 5.0);
        Set<Map.Entry<String,Double>> s = map.entrySet();
        Stream<Map.Entry<String,Double>> s3 = s.stream();


        //4.数组
        String[] array = new String[]{"a", "b", "c", "d", "e", "f"};
        Stream<String> s4 = Arrays.stream(array);
        Stream<String> s5 = Stream.of(array);
    }
}
