package com.self.CollectionsFramework.Collection.CollectionErgodic.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        c.add("F");
        //创建迭代器对象
        Iterator<String> it = c.iterator();
        while (it.hasNext()){//询问迭代器指向的位置有没有元素，默认从第一位置开始
            String r = it.next();//获取迭代器当前位置的元素，并将迭代器对象指向下一元素
            System.out.println(r);
        }
    }
}
