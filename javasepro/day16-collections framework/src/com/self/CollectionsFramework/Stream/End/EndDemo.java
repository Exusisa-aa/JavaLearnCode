package com.self.CollectionsFramework.Stream.End;

import com.self.CollectionsFramework.Stream.Process.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class EndDemo {
    public static void main(String[] args) {

        List<com.self.CollectionsFramework.Stream.Process.Student> list = new ArrayList<>();
        Student s1 = new Student("蜘蛛精",26,172.5);
        Student s2 = new Student("蜘蛛精",26,172.5);
        Student s3 = new Student("紫霞",23,167.6);
        Student s4 = new Student("白晶晶",25,169.0);
        Student s5 = new Student("牛魔王",35,183.3);
        Student s6 = new Student("牛夫人",34,168.5);
        Collections.addAll(list,s1,s2,s3,s4,s5,s6);


        //1.计算出身高超过168的有几人
        System.out.println(list.stream().filter(s -> s.getScore() > 168).count());
        System.out.println("-----------------------------------");


        //2.找出身高最高的学生对象并输出
        System.out.println(list.stream().max(Comparator.comparing(Student::getScore)).get());
        System.out.println("-----------------------------------");


        //3.找出身高最矮的学生对象并输出
        System.out.println(list.stream().min(Comparator.comparing(Student::getScore)).get());
        System.out.println("-----------------------------------");


        //4.找出身高超过170的学生放到一个新的list和set集合之中去
        List<Student> students1 = list.stream().filter(s -> s.getScore() > 170).collect(Collectors.toList());
        System.out.println(students1);

        Set<Student> students2 = list.stream().filter(s -> s.getScore() > 170).collect(Collectors.toSet());
        System.out.println(students2);

        System.out.println("-----------------------------------");

        //5.找出身高超过170的学生放到一个新的map集合之中去
        Map<String,Double> student3 = list.stream().filter(s -> s.getScore() > 170).distinct().collect(Collectors.toMap(Student::getName,Student::getScore));
        System.out.println(student3);
        System.out.println("-----------------------------------");


        //6.找出身高超过170的学生放到一个新的数组之中去
        Student[] students4 = list.stream().filter(s -> s.getScore() > 170).toArray(Student[]::new);
        System.out.println(Arrays.toString(students4));


        //forEach遍历元素  count计算元素个数  max与get获取元素最大值  min与get获取元素最小值
        //collect收集处理流  Collectors.toList/toSet/toMap处理流转集合  toArray收集处理流转数组



    }
}
