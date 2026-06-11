package com.self.CollectionsFramework.Collection.CollectionModificationException;

import java.util.ArrayList;
import java.util.Iterator;

public class ModificationExceptionDemo {
    public static void main(String[] args) {
        //删除带 李 字的元素
        ArrayList<String> list = new ArrayList<>();
        list.add("王麻子");
        list.add("小李子");
        list.add("李爱华");
        list.add("张全蛋");
        list.add("晓李");
        list.add("李玉刚");
        System.out.println(list);

        Iterator<String> it = list.iterator();

//        while (it.hasNext()) {
//            String name = it.next();
//            if(name.contains("李")){
//                list.remove(name);
//            }
//        }  集合并发异常  必须用迭代器调remove方法

//        for (String name : list) {
//            if(name.contains("李")) {
//                list.remove(name);
//            }
//        }  集合并发异常   必须用for并i-- 或  倒着遍历for



//        方案一：
//        while (it.hasNext()) {
//          String name = it.next();
//           if(name.contains("李")){
//              it.remove();
//           }
//       }
//        System.out.println(list);


        //方案二
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).contains("李")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);


//        //方案三
//        for (int i = list.size()-1; i >= 0; i--) {
//            if(list.get(i).contains("李")){
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
    }
}
