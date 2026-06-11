package com.self.CollectionsFramework.Collection.ListBasis.LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //链表特点：查询时必须从第一个或最后一个开始查，索引查询比较慢；增删时，只用该某个节点的地址，故增删数据比较快

        LinkedList<String> list = new LinkedList<>();
        //LinkedList特有的方法
        //头部增加
        list.addFirst("1");
        list.push("0.5");
        System.out.println(list);
        System.out.println("---------------");
        //尾部增加
        list.addLast("2");
        System.out.println(list);
        System.out.println("---------------");
        //得到信息
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println("---------------");
        //头部移除
        list.removeFirst();
        System.out.println(list);
        System.out.println("---------------");
        //尾部移除
        list.removeLast();
        System.out.println(list);
        System.out.println("---------------");

        //场景一：列队：先进先出后进后出
        LinkedList<String> list2 = new LinkedList<>();
        list2.addLast("一号病人");
        list2.addLast("二号病人");
        list2.addLast("三号病人");
        list2.addLast("四号病人");
        list2.addLast("五号病人");
        System.out.println(list2);
        System.out.println(list2.removeFirst());
        System.out.println(list2.removeFirst());
        System.out.println(list2.removeFirst());
        System.out.println(list2);
        System.out.println("---------------");

        //场景二：栈设计：先进后出后进先出
        LinkedList<String> list3 = new LinkedList<>();
        list3.addFirst("第一颗子弹");
        list3.addFirst("第二颗子弹");
        list3.push("第三颗子弹");
        list3.push("第四颗子弹");//push压栈
        list3.push("第五颗子弹");
        System.out.println(list3);
        System.out.println(list3.removeFirst());
        System.out.println(list3.removeFirst());
        System.out.println(list3.pop());//pop出栈
        System.out.println(list3);
    }
}
