package com.self.CollectionsFramework.Collection.ChangedDate;

import java.util.Arrays;

public class ChangedDateDemo {
    public static void main(String[] args) {
        calculate("陈");//可变参数可不传数据，可传一个或多个数据，也可传一个数组
        calculate("陈",2,3,4);
        calculate("陈",2);
        int[] array = {2,3,4,5,6,7,8,9};
        calculate("陈",array);
    }


    //在方法内部默认为数组
    //一个形参列表只能有一个可变参数
    //可变参数必须放在形参列表的后面
    public static void calculate(String name,int...numbers){
        System.out.println(name + Arrays.toString(numbers));
        System.out.println("----------------------");
    }
}
