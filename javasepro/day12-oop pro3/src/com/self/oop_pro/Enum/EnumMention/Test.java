package com.self.oop_pro.Enum.EnumMention;

public class Test {
    public static void main(String[] args) {
        A a = A.X;
        System.out.println(a.getName());
        AbstractA.Y.print();
        A[] as = A.values();
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i].getName());
        }

        System.out.println(A.valueOf("Y").ordinal());
    }
}
