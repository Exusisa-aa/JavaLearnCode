package com.self.more_API.ArraysOppOrder1;

import java.util.Arrays;

public class ArraysOppDemo {


    public static void main(String[] args) {
        Student s1 = new Student("小明",18,66.7);
        Student s2 = new Student("小陈",16,100.5);
        Student s3 = new Student("小村",23,98.7);
        Student s4 = new Student("小红",17,97.6);
        Student s5 = new Student("小雷",26,70.5);
        Student[] students = {s1,s2,s3,s4,s5};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
