package com.self.CollectionsFramework.Map.MapInMap;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        List<String> js = new ArrayList<>();
        Collections.addAll(js,"南京市","扬州市","苏州市","无锡市","常州市");
        List<String> hub = new ArrayList<>();
        Collections.addAll(hub,"武汉市","孝感市","十堰市","宜昌市","鄂州市");
        List<String> heb = new ArrayList<>();
        Collections.addAll(heb,"石家庄市","唐山市","邢台市","保定市","张家口市");

        map.put("江苏省",js);
        map.put("湖北省",hub);
        map.put("河北省",heb);

        map.forEach((k,v) -> System.out.println(k+"\t"+v));
    }
}
