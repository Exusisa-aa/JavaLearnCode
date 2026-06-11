package com.self.importing.basicdatatype;

public class BasicDtaType {
    public static void main(String[] args) {
        //基本数据类型的使用
        //整数
        byte n1 = 127;
        System.out.println(n1);
//        byte n2 = 128;   越界了
//        byte n3 = -129;  越界了
        short n2 =32767;
        System.out.println(n2);
//        short n2 = 99999;  越界了
        int n3 = 6666666;
        System.out.println(n3);
        long n4 = 35413438541384L;
        System.out.println(n4);
        //小数
        float n5 = 3.14F;
        System.out.println(n5);
        double n6 = 3.1415926535;
        System.out.println(n6);
        double n7 =5.15135454135413541351135151351;
        System.out.println(n7);
        //字符
        char n8 = '中';
        System.out.println(n8);
        char n9 ='国';
        System.out.println(n9);
//        char n10 = "中国"; 报错   char只能用于字符不能是字符串
        boolean n10 = true;
        boolean n11 = false;
        System.out.println(n10);
        System.out.println(n11);
        String n12 = "一个字符串";
        System.out.println(n12);
    }
}
