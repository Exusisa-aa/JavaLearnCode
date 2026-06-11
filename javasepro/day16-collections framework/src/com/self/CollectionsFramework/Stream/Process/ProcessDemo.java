package com.self.CollectionsFramework.Stream.Process;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ProcessDemo {
    public static void main(String[] args) {
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores,88.5,100.0,60.0,99.0,9.5,99.6,25.0);
        //1.找出成绩大于等于60分并升序输出
        scores.stream().filter(s -> s >= 60).forEach(System.out::println);
        System.out.println("-----------------------------------");

        List<Student> list = new ArrayList<>();
        Student s1 = new Student("蜘蛛精",26,172.5);
        Student s2 = new Student("蜘蛛精",26,172.5);
        Student s3 = new Student("紫霞",23,167.6);
        Student s4 = new Student("白晶晶",25,169.0);
        Student s5 = new Student("牛魔王",35,183.3);
        Student s6 = new Student("牛夫人",34,168.5);
        Collections.addAll(list,s1,s2,s3,s4,s5,s6);


        //2.找出年龄大于等于23，小于等于30岁的人，并按照年龄降序输出
        list.stream().filter(s -> s.getAge() >= 23 && s.getAge() <= 30).sorted((o1,o2) -> Integer.compare(o2.getAge(), o1.getAge())).forEach(System.out::println);
        System.out.println("-----------------------------------");


        //3.取出身高最高的前三名学生并输出
        list.stream().sorted((o1,o2) -> Double.compare(o2.getScore(), o1.getScore())).limit(3).forEach(System.out::println);
        System.out.println("-----------------------------------");


        //4.取出身高倒数的两名学生并输出
        list.stream().sorted((o1,o2) -> Double.compare(o2.getScore(),o1.getScore())).skip(list.size() - 2).limit(2).forEach(System.out::println);
        System.out.println("-----------------------------------");


        //5.找出身高超过168的学生叫什么名字，并去除重复的名字再输出
        //若装的是对象，使用distinct方法时要重写equals和HashCode方法
        list.stream().filter(s -> s.getScore() > 168).map(Student::getName).distinct().forEach(System.out::println);
        System.out.println("-----------------------------------");

        //合并两个流
        Stream<String> ss1 = Stream.of("1","2","3");
        Stream<String> ss2 = Stream.of("4","5","6");
        Stream<String> ss3 = Stream.concat(ss1, ss2);
        ss3.forEach(System.out::println);

        //filter过滤元素  sorted排序元素  limit获取元素（从头开始）  skip跳过元素
        //distinct删除重复元素   map把流换新流  concat合并流



    }
}
