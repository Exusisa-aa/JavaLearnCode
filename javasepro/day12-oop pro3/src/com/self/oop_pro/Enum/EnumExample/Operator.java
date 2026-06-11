package com.self.oop_pro.Enum.EnumExample;

public class Operator {
    public static void main(String[] args) {
        check(SexConstant.GIRL);
    }
    public static void check(SexConstant SEX){
        switch (SEX){
            case BOY :
                System.out.println(SEX.getAge() + "岁的" + SEX.getName() + "先生喜欢" + SEX.getHobby());
                break;
            case GIRL:
                System.out.println(SEX.getAge() + "岁的" + SEX.getName() + "女士喜欢" + SEX.getHobby());
                break;
        }
    }
}
