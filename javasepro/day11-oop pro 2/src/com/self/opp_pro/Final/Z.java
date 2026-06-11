package com.self.opp_pro.Final;

public class Z extends F1{
//    @Override
//    public void print(){
//
//    }  修饰方法不能被重写
    public static final String SCHOOL_NAME = "深圳职业技术大学";
//    3. static final 用来修饰常量,常量名大写且用_链接,无法被修改


public static void main(String[] args) {
    final double z = 0.3;
//    z = 0.6;
    //修饰基本变类型量数据不能被修改
    buy(z);

    final int[] arr = {11,22,33,44,55};
    //修饰引用数据类型地址不能被修改，但数据可以被修改
    arr[1] = 222;
}

    public static void buy(final double z){

    }
}
