package com.self.Advanced.Annotation.ParseAnnotation;

@TestForTest(value = "chen",aaa = 99,bbb = {"m","h"})
public class Demo {
    @TestForTest(value = "zhuo",aaa = 101, bbb={"h","m"})
    public void test1(){

    }
}
