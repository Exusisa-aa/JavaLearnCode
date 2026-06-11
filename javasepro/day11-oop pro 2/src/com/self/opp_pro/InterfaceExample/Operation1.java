package com.self.opp_pro.InterfaceExample;

import java.util.ArrayList;

public class Operation1 implements StudentOperator{
    @Override
    public void printAll(ArrayList<Student> classManager){
        System.out.println("=============学生信息如下=============");
        int numbers = 0;
        for (int i = 0; i < classManager.size(); i++) {
            System.out.println("姓名：" + classManager.get(i).getName());
            System.out.println("性别：" + classManager.get(i).getSex());
            System.out.println("成绩：" + classManager.get(i).getScore());
            numbers++;
            System.out.println("==============================");
        }
        System.out.println("一共有" + numbers + "人");
    }

    @Override
    public void averageScore(ArrayList<Student> classManager){
        int sum = 0;
        for (int i = 0; i < classManager.size(); i++) {
            sum += classManager.get(i).getScore();
        }
        System.out.println("平均分为：" + sum / (classManager.size()));
    }
}
