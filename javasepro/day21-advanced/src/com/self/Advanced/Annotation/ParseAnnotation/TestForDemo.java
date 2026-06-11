package com.self.Advanced.Annotation.ParseAnnotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


public class TestForDemo {
    @Test
    public void ParseClass0(){
        Class d = Demo.class;
        Annotation[] annotations = d.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void ParseClass1(){
        Class d = Demo.class;
        if(d.isAnnotationPresent(TestForTest.class)){
            TestForTest testForTest = (TestForTest)d.getDeclaredAnnotation(TestForTest.class);
            System.out.println(testForTest.aaa());
            System.out.println(Arrays.toString(testForTest.bbb()));
            System.out.println(testForTest.value());
        }

    }

    @Test
    public void ParseMethod() throws Exception{
        Class d = Demo.class;
        Method m = d.getDeclaredMethod("test1");
        if(m.isAnnotationPresent(TestForTest.class)){
            TestForTest testForTest =m.getDeclaredAnnotation(TestForTest.class);
            System.out.println(testForTest.aaa());
            System.out.println(Arrays.toString(testForTest.bbb()));
            System.out.println(testForTest.value());
        }

    }
}
