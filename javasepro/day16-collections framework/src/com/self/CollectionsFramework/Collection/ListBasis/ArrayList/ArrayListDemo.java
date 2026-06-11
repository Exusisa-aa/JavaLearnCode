package com.self.CollectionsFramework.Collection.ListBasis.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");


        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for(String s : list1){
            System.out.println(s);
        }

        list1.forEach(System.out::println);

        //适用于经常查询但不经常增删的数据
        //每次超出容量会创建新数组并扩容，把原数组的数据添加到新数组之中去
        //特点是查询效率极高而增删数据效率极低
    }
}
