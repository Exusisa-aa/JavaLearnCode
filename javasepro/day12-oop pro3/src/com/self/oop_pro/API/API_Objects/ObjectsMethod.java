package com.self.oop_pro.API.API_Objects;

import java.util.Objects;

public class ObjectsMethod {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "zhm";
        System.out.println(Objects.equals(s1, s2));//更安全，遇到null不会报错
        System.out.println(Objects.isNull(s1));//判断是否为null
        System.out.println(Objects.isNull(s2));
        System.out.println(Objects.nonNull(s1));//判断是否不为null
        System.out.println(Objects.nonNull(s2));
    }
}
