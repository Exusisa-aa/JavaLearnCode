package com.self.importing.ASCLL;

public class ASCLLDemo {
    public static void main(String[] args){
        char number = 'A' + 10;
        System.out.println(number);
        //A在ASC LL中为编号65且后十位为K
        System.out.println('A' + 10);//65+10=75
        System.out.println('0' + 10);//48+10=58
        System.out.println('a' + 10);//97+10=107
        //如果我不知道某个ASC LL编号可以用以上运算来检测
        System.out.println("-----------------");
        //二进制 八进制  十六进制的书写    书写后转为十进制
        int n21 = 0B111011101001;
        System.out.println(n21);
        int n22 = 0b111011101001;
        System.out.println(n22);
        int n8 = 07351;
        System.out.println(n8);
        int n161 = 0XFA;
        System.out.println(n161);
        int n162 = 0xFA;
        System.out.println(n162);
        System.out.println("-----------------");
    }
}
