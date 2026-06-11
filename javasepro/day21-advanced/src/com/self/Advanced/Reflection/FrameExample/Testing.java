package com.self.Advanced.Reflection.FrameExample;

public class Testing {

    public static void main(String[] args) {
        Teacher t = new Teacher("张三",42,"java");
        Student s = new Student("李四",20,"大一");

        Frame.saveObject(t);
        Frame.saveObject(s);
    }
}
