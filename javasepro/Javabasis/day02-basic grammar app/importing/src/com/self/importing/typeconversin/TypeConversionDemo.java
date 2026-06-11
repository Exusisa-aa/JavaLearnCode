package com.self.importing.typeconversin;

public class TypeConversionDemo {
    public static void main(String[] args) {
        //自动类型转换机制
        byte n1 = 20;
        int n2 = n1;
        System.out.println(n1);
        System.out.println(n2);
        int n3 = 30;
        float n4 = n3;
        System.out.println(n3);
        System.out.println(n4);
        char n5 = 'A';
        int n6 = n5;
        System.out.println(n5);
        System.out.println(n6);
        //表达式的自动类型转换
        byte a = 20;
        short b = 30;
        long c = 10L;
        long rs = a + b + c;
        System.out.println(rs);
        int d = 50;
        double rs2 = a + b + c + d + 1.0;
        System.out.println(rs2);
        byte i = 100;
        short j = 200;
//        short rs3 = i + j; 错误的  因为byte short char的运算结果归于int 以防超出原类型的数据上限
        int rs3 = i + j;
        System.out.println(rs3);
        //强制类型转换
        int m = 20;
        byte n = (byte) m;
        System.out.println(n);
        int nm = 1500;
        byte mn = (byte) nm;
        System.out.println(mn);
        /*
        结果是-36的原因；由于byte在八位只截取到了最后八位为11011100，首位为符号位，1是负数，0是正数，正数的补码是原码，而负数
        的补码是符号位不变，数值位取反并且在最后一位加1：1 1011100→1 0100011→1 0100100，所以读出来为-36
         */
        double hh = 2000.5468;
        int nn = (int) hh;
        System.out.println(nn);
    }
}
