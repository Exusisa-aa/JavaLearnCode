package com.self.importing.operator;

public class Operator {
    public static void main(String[] args) {
        //基本算数运算符的使用
        int c = 10;
        int b = 2;
        System.out.println(c + b);//12
        System.out.println(c - b);//8
        System.out.println(c * b);//20
        System.out.println(c * 1.0 * b);//20.0
        System.out.println(c / b);//5
        System.out.println(c * 1.0 / b);//5.0
        System.out.println(5 / 2);//2  在java中整数除以整数等于整数  必须使其中一位变成小数
        System.out.println(5.0 / 2);//2.5
        int i =5;
        int j =2;
        System.out.println(i / j);//2
        System.out.println(i * 1.0 / 2);//2.5
        System.out.println(3 % 2);//1
        System.out.println(c % b);//0
        System.out.println("-------------------------------------");
        //加号为连接符时的使用与辨别
        int a = 5;
        System.out.println("abc" + a);//abc5
        System.out.println(a + 5);//10
        System.out.println('a' + 1);//检验a的ASC LL编码
        System.out.println('a' + a);//102
        System.out.println("self" + a + 'a');//"self5a"
        System.out.println(a + 'a' + "self");//"102self"
        System.out.println("-------------------------------------------------");
        //自增自减运算符的单独使用
        int m = 5;
        m++;m++;++m;++m;//9
        System.out.println(m);
        int n = 5;
        n--;n--;--n;--n;//1
        System.out.println(n);
        System.out.println("---------------------------------------");
        //自增自减运算符的非单独使用
        int nn = 5;
        int rs1 = ++nn;
        System.out.println(nn);//6
        System.out.println(rs1);//6
        int jj = 5;
        int rs3 = jj++;
        System.out.println(jj);//6
        System.out.println(rs3);//5
        int mm = 5;
        int rs2 = mm--;
        System.out.println(mm);//4
        System.out.println(rs2);//5
        int ii = 5;
        int rs4 = --ii;
        System.out.println(ii);//4
        System.out.println(rs4);//4
        System.out.println("-------------------");
        //自增自减例题
        int z = 10;
        int x = 5;
        int rs5 = z++ + ++z - --x - ++x + 1 + z--;
        System.out.println(rs5);/*
        26=10+12-4-5+1+12 随着从左到右z与x的值在不断改变，但不一定把改变后的数作为项，符号在前就可以作为项，符号在后就把改变前的数作为项。
        */
        System.out.println(z);//11
        System.out.println(x);//5
        System.out.println("-----------------------------------------------------------------------------------");
        //扩展赋值运算符的使用
        byte kl = 10;
        byte lk = 5;
        //kl = lk + kl;   报错原因： java默认为int 而等号前的kl为byte 无法赋值//
        kl = (byte) (lk + kl);
        kl += lk;
        System.out.println(kl);
        kl = (byte) (kl - lk);
        kl -= lk;
        System.out.println(kl);
        kl = (byte) (kl*lk);
        kl *= lk;        //本来为250 但byte只占一字节 只能到127 250为11111010 根据补码取反加1 为10000110 即为-6
        System.out.println(kl);
        kl = (byte) (kl/lk);
        kl /= lk;
        System.out.println(kl);  //本来为-0.25 但是byte是整数类型  故只保留整数
        kl = (byte) (kl%=lk);
        kl %=lk;
        System.out.println(kl);
        System.out.println("-------------------------------------------------------------------------");
        //关系运算符的基本使用
        int kk = 10;
        int ll = 5;
        boolean rs = kk > ll;
        System.out.println(rs);//true
        System.out.println(10 >= 5);//true
        System.out.println(5 >= 5);//true
        System.out.println(10 <= 5);//false
        System.out.println(10 == 10);//true
        System.out.println(10 != 10);//false
        System.out.println("-----------------------------------------------");
        //逻辑运算符的使用
        //要筛选一个东西 这个东西length为100 width为90
        int length = 101;
        int width = 89;
        boolean rrs =(length>=100 & width>=90);
        System.out.println(rrs);//false
        System.out.println(100 > 99 & 100 > 98);//true
        System.out.println(100 >= 99 | 100 <= 102);//true
        System.out.println(100 >= 101 | 100 >= 102);//false
        System.out.println(!(true));//false
        System.out.println(!(100 >= 99 & 100 >= 98));//false
        System.out.println(100 >= 99 ^ 100 >= 98);//false
        System.out.println(100 >= 99 ^ 100 <= 98);//true
        int gg = 10;
        int vv = 20;
        int yy = 20;
        boolean rsss = (gg > 11 && vv ++ <100);//因为左边为false 所以右边不执行
        boolean as = (gg < 11 && yy ++ <100);//因为左边为true 所以右边执行
        System.out.println(vv);//20
        System.out.println(yy);//21
        int aa = 10;
        int bb = 20;
        int cc = 20;
        boolean sa = (aa < 11 || bb ++ <100);//因为左边为true 所以右边不执行
        boolean ds = (aa > 11 || cc ++ <100);//因为左边为false 所以右边执行
        System.out.println(bb);//20
        System.out.println(cc);//21
        System.out.println("-------------------------------------------------------");
        //三元运算符的基本使用
        //某次考试成绩及格为60
        String mingscore = 95 >= 60 ? "成绩及格":"成绩不及格";
        System.out.println(mingscore);
        String hongscore = 59 >= 60 ? "成绩及格":"成绩不及格";
        System.out.println(hongscore);
        int vm = 10;
        int vn = 20;
        int xx = vm > vn ? vm : vn;
        System.out.println(xx);
        //三个数据取最大值
        int abc = 30;
        int def = 45;
        int ghi = 60;
        int temp = abc > def ? abc : def;
        int example = temp > ghi ? temp : ghi;
        System.out.println(example);
        System.out.println(10 > 3 || 10 > 3 && 10 < 3);//&&优先级高于|| 故出现true
        System.out.println((10 > 3 || 10 > 3) && 10 < 3);//()优先级最高 故出现false
    }
}
