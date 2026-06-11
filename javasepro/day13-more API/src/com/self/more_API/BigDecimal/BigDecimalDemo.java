package com.self.more_API.BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        System.out.println((a + b));
        System.out.println("=====================");
        BigDecimal a1 = new BigDecimal(Double.toString(a));//不推荐
        BigDecimal b1 = BigDecimal.valueOf(b);//推荐
        System.out.println(a1.add(b1));//加
        System.out.println("=====================");
        System.out.println(a1.subtract(b1));//减
        System.out.println("=====================");
        System.out.println(a1.multiply(b1));//乘
        System.out.println("=====================");
        System.out.println(a1.divide(b1,2, RoundingMode.HALF_UP));//除 位数 模式
        BigDecimal c = BigDecimal.valueOf(1);
        BigDecimal d = BigDecimal.valueOf(3);
        System.out.println(c.divide(d, 2, RoundingMode.HALF_UP));
        BigDecimal rs = c.divide(d,2,RoundingMode.HALF_UP);
        System.out.println(rs.doubleValue());
    }
}
