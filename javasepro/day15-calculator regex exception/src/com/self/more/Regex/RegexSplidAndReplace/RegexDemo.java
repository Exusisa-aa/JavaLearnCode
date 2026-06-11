package com.self.more.Regex.RegexSplidAndReplace;

import java.util.Arrays;

public class RegexDemo {
    public static void main(String[] args) {
        String rs1 = "陈5153张wmadw荣da1w5d1w仇";
        System.out.println(rs1.replaceAll("\\w+", "-"));
        String rs2 = "我我我喜欢编编编编编编程程";
        System.out.println(rs2.replaceAll("(.)\\1+", "$1"));
        String rs3 = "陈5153张wmadw荣da1w5d1w仇";
        String[] rs4 = rs3.split("\\w+");
        System.out.println(Arrays.toString(rs4));
    }
}
