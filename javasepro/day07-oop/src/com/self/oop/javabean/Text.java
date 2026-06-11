package com.self.oop.javabean;

public class Text {
    public static void main(String[] args) {
     Student s1 = new Student();
     s1.setName("小明");
     s1.setScore(93);
     System.out.println(s1.getName());
     System.out.println(s1.getScore());

     StudentOperators operator = new StudentOperators(s1);
     operator.printPass();
    }
}
