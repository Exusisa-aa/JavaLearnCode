package com.self.more_API.Lambda.ProMax.SpecificSite;

import java.util.Arrays;


public class SpecificSiteDemo {
    public static void main(String[] args) {
        String[] name = {"body","angela","Andy","draw","caoSh","Bob","jack","Jacky","cycle"};
//        Arrays.sort(name, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });

//        Arrays.sort(name,(o1,o2) -> o1.compareToIgnoreCase(o2));

        Arrays.sort(name,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(name));
    }
}
