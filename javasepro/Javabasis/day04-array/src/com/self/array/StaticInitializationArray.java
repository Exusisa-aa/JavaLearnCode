package com.self.array;

public class StaticInitializationArray {
    public static void main(String[] args) {
        //静态初始化数组的使用
        int[] ages ={12,24,36};
        double[] score ={20.0,30.5,60.8,98.9};
        System.out.println(ages);
        System.out.println(score);
        //[为地址  I与D为数据类型  @为介导  后面的数字为16进制数
        System.out.println("=====================================================");
        //数组的访问
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
//        System.out.println(ages[3]); 报错超出数组的最大索引
        System.out.println("=====================================================");
        //数组的修改
        ages[0] = 66;
        ages[2] = 100;
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
        System.out.println("====================================================");
        //访问数组的长度
        System.out.println(ages.length);
        //访问数组的最大索引数  前提是数组不为空
        System.out.println(ages.length - 1);
        System.out.println("============================================================");
        //数组的遍历
        String[] name ={"小红","小明","小刚","小陈","小水"};
        for (int i = 0; i < name.length; i++){
            System.out.println(name[i]);
        }
//        for (int i = 0; i < name.length; i++) {
//            System.out.println(name[i]);
//        }                      用  数据名.fori可直接写出遍历
        System.out.println("==========================================================================");
        //案例：某部门5名员工的销售额是：16、26、36、6、100,请计算出他们的销售总额
        int[] employee = {16,26,36,6,100};
        int sum = 0;
        for (int i = 0 ;i < employee.length; i++){
            sum += employee[i];
        }
        System.out.println(sum);
    }
}

