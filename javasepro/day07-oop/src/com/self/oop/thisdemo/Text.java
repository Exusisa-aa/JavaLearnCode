package com.self.oop.thisdemo;

public class Text {
    public static void main(String[] args) {
        Student s2 = new Student();
        s2.name = "小红";
        s2.score = 670;
        System.out.println(s2);
        s2.url();

        Student s3 = new Student();
        s3.name = "小刚";
        s3.score = 690;
        System.out.println(s3);
        s3.url();

        Student s1 = new Student();
        s1.name = "小明";
        s1.score = 730;
        s1.scorePass(720);
    }

}
