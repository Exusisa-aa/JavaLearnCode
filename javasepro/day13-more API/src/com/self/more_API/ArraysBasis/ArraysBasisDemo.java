package com.self.more_API.ArraysBasis;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.IntFunction;

public class ArraysBasisDemo {
    public static void main(String[] args) {
        //1.返回数组内容
        int[] array1 = {10, 20, 30, 40, 50, 60};
        System.out.println(Arrays.toString(array1));
        System.out.println("====================");

        //2.拷贝数据包前不包后
        int[] array2 = Arrays.copyOfRange(array1, 1, 4);//20,30,40
        System.out.println(Arrays.toString(array2));
        System.out.println("===================");

        //3.拷贝数据并创建新数组时给定长度
        int[] array3 = Arrays.copyOf(array1, 10);
        System.out.println(Arrays.toString(array3));//超出部分自动补零
        int[] array4 = Arrays.copyOf(array1, 3);
        System.out.println(Arrays.toString(array4));//不足就忽略其后
        System.out.println("========================");

        //4.改掉所有数据
        BigDecimal b1 = BigDecimal.valueOf(99.8);
        BigDecimal b2 = BigDecimal.valueOf(103.5);
        BigDecimal b3 = BigDecimal.valueOf(48.2);
        BigDecimal b4 = BigDecimal.valueOf(39.3);
        BigDecimal b5 = BigDecimal.valueOf(57.8);
        BigDecimal[] array5 = {b1, b2, b3, b4, b5};
        Arrays.setAll(array5, new IntFunction<BigDecimal>() {
            @Override
            public BigDecimal apply(int value) {
                return array5[value].multiply(BigDecimal.valueOf(0.8));
            }
        });
        System.out.println(Arrays.toString(array5));

        //5.排序 默认升序
        Arrays.sort(array5);//升序
        System.out.println(Arrays.toString(array5));
        Arrays.sort(array5,(o2,o1) -> o1.compareTo(o2));//降序
        System.out.println(Arrays.toString(array5));
    }
}
