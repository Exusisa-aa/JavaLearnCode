package com.self.oop_pro.API.API_StringBuilder_StringBuffer;

public class Benefit {
    public static void main(String[] args) {
//        //    1.String  运算速度慢
//        String a = "";
//        for (int i = 0; i < 1000000; i++) {
//            a = a + "abc";
//        }
//        System.out.println(a);
//    }



//        2.StringBuilder
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            a.append("abc");
        }
        System.out.println(a);
    }

//    拼接少用String，拼接多用StringBuilder，更安全用StringBuffer
}
