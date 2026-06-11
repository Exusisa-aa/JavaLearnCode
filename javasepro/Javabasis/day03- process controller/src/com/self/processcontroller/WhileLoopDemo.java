package com.self.processcontroller;

public class WhileLoopDemo {
    public static void main(String[] args) {
    int i = 0;
    while (i <= 5){
        System.out.println("Hello World");
        i++;
    }
    //珠穆朗玛峰的while循环例子
    //用一张纸折叠知道大于或等于珠穆朗玛峰的高度 其中纸的初始厚度为0.1mm  而珠穆朗玛峰高度为8848860mm
        double chomolangmapeak = 8848860.0;
        double paper = 0.1;
        int fold = 0;
        while (paper < chomolangmapeak){
            fold += 1;
            paper *=2;
    }
        System.out.println("需要折叠的次数；" + fold);
        System.out.println("最终纸张的厚度为：" + paper);
        System.out.println("-----------------------------------------------");
        int fold1 = 0;
        for (double pap = 0.1; pap < chomolangmapeak; pap *=2){
            fold1 += 1;
        }
        System.out.println("需要折叠的次数；" + fold1);
        System.out.println("最终纸张的厚度：" + paper);
    }

}
