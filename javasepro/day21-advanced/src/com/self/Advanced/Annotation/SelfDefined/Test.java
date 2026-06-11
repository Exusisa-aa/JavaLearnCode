package com.self.Advanced.Annotation.SelfDefined;

public class Test {
    @TestForTest(name = "chen",age = 18, gender = "man")
    public void test1()
    {
        System.out.println("test1");
    }
}
