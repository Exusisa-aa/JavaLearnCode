package com.self.Advanced.junit.Use;

import org.junit.*;

public class TestStringUnit {
    @Before
    public void before(){
        System.out.println("开始测试");
    }

    @After
    public void After(){
        System.out.println("测试结束");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("开始测试");
    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("测试结束");
    }

    @Test
    public void testGetLength() {
        System.out.println(StringUnit.getLength("12"));
    }

    @Test
    public void testGetLength1() {
        System.out.println(StringUnit.getLength(null));
    }

    @Test
    public void testGetMaxIndex() {
        System.out.println(StringUnit.getMaxIndex("123"));
    }

    @Test
    public void testGetMaxIndex1() {
        int num = StringUnit.getMaxIndex("123");
        System.out.println(num);
        Assert.assertEquals("有bug",2,num);//num与期望值一样则通过，不一样则报错
    }
}
