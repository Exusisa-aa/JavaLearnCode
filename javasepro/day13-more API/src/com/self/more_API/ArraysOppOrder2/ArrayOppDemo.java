package com.self.more_API.ArraysOppOrder2;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayOppDemo {
    public static void main(String[] args) {
        Student s1 = new Student("小明",18,66.7);
        Student s2 = new Student("小陈",16,100.5);
        Student s3 = new Student("小村",23,98.7);
        Student s4 = new Student("小红",17,97.6);
        Student s5 = new Student("小雷",26,70.5);


        Student[] students = {s1,s2,s3,s4,s5};
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getScore(),o2.getScore()); //先左后右为升序

//                return Double.compare(o2.getScore(),o1.getScore()); //先右后左为降序


//                if(o1.getScore() > o2.getScore()){
//                    return 1; //左大于右返回正整数为升序
//                } else if (o1.getScore() < o2.getScore()) {
//                    return -1;
//                }
//                return 0;

//                if(o1.getScore() > o2.getScore()){
//                    return -1; //左大于右返回负整数为降序
//                } else if (o1.getScore() < o2.getScore()) {
//                    return 1;
//                }
//                return 0;
            }
        });

        System.out.println(Arrays.toString(students));
    }
}
