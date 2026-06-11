package com.self.CollectionsFramework.Collection.SetBasis.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    //无序  不重复  无索引
    //HashSet基于哈希表实现，哈希表=数组＋链表＋红黑树
    public static void main(String[] args) {
        Set<Student> students =  new HashSet<>();
        //创建一个默认长度为16的数组，满了扩容1.75倍
        Student s1 = new Student("小明",20,95);
        Student s2 = new Student("小红",21,92.5);
        Student s3 = new Student("小红",21,92.5);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        //索引值根据哈希值和数组长度计算
        //索引位置为null则存入，不为null则用equals比较，相等不存入，不相等时，若链表长度和数组长度较小则直接挂老数据的下面，若链表长度和数组长度较大则用红黑树挂在老数据下面
        System.out.println(students);
        //由于每个对象地址不同故哈希值不同，计算出来的索引值不同，导致存入了内容相同的对象
        //解决方法：在数据类中重写equals方法和HashCode方法，当对象内容相同时返回相同的哈希值，则索引值相同，进而用equals方法判断相同时则不存入数组
    }
}
