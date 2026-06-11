package com.self.more.Regex.RegexJudgeBasis;

public class Demo {
    public static void main(String[] args) {
        System.out.println(checkQQ1("2447439574"));
        System.out.println(checkQQ1("244gkag574"));
        System.out.println(checkQQ1(""));
        System.out.println(checkQQ1("0447439574"));
        System.out.println("=========================");
        System.out.println(checkQQ2("2447439574"));
        System.out.println(checkQQ2("244gkag574"));
        System.out.println(checkQQ2(""));
        System.out.println(checkQQ2("0447439574"));
    }

    public static boolean checkQQ2(String qq) {
        return qq.matches("[1-9]//d{5,19}");
    }

    public static boolean checkQQ1(String qq) {
        if(qq == null || qq.startsWith("0") || qq.length() < 6  || qq.length() > 20){
            return false;
        }
        for(int i = 0; i < qq.length(); i++){
            char ch = qq.charAt(i);
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
