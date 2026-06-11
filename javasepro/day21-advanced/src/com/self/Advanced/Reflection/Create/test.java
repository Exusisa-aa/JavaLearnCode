package com.self.Advanced.Reflection.Create;

public class test {
    public static void main(String[] args) {
        //1
        Class c1 = Students.class;
        System.out.println(c1.getName());//全类名
        System.out.println(c1.getSimpleName());

        //2
        try {
            Class c2 = Class.forName("com.self.Advanced.Reflection.Create.Students");
            System.out.println(c2 == c1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //3
        Students s = new Students();
        Class c3 = s.getClass();
        System.out.println(c3 == c1);
    }
}
