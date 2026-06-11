package com.self.oop_pro.API.API_Object;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("小明",18);
        System.out.println(s1.toString());
        Student s2 = new Student("小明",18);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Clone a = new Clone("小明",18,new double[]{100,90});
        Clone b = (Clone) a.clone();
        System.out.println(a.getScore());
        System.out.println(b.getScore());
        System.out.println(b.toString());
        CloneDeep d = new CloneDeep("小明",18,new double[]{100,90});
        CloneDeep c = (CloneDeep) d.clone();
        System.out.println(d.getScore());
        System.out.println(c.getScore());
    }
}
