package com.self.oop_pro.Generics.GenericsInterface;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        new StudentOperation().add(s1);
        new StudentOperation().printInformation(s1);
        Teacher t1 = new Teacher();
        new TeacherOperation().add(t1);
        new TeacherOperation().printInformation(t1);
    }
}
