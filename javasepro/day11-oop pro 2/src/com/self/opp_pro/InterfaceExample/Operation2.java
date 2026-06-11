package com.self.opp_pro.InterfaceExample;

import java.util.ArrayList;
import java.util.Objects;

public class Operation2 implements StudentOperator{
    @Override
    public void printAll(ArrayList<Student> classManager){
        int numbers = 0;
        int nv = 0;
        int nan = 0;
        System.out.println("=============学生信息如下=============");
        for (int i = 0; i < classManager.size(); i++) {
            System.out.println("姓名：" + classManager.get(i).getName());
            System.out.println("性别：" + classManager.get(i).getSex());
            System.out.println("成绩：" + classManager.get(i).getScore());
            numbers++;
            if(Objects.equals(classManager.get(i).getSex(),'男')){
                nan++;
            }else {
                nv++;
            }
            System.out.println("==============================");
        }
        System.out.println("一共有" + numbers + "人");
        System.out.println("女生有" + nv + "人");
        System.out.println("男生有" + nan + "人");
    }

    @Override
    public void averageScore(ArrayList<Student> classManager){
        int sum = 0;
        double max = classManager.get(0).getScore();
        double min = classManager.get(0).getScore();
        for (int i = 0; i < classManager.size(); i++) {
            sum += classManager.get(i).getScore();
            if(classManager.get(i).getScore() > max){
                max = classManager.get(i).getScore();
            } else if (classManager.get(i).getScore() < min) {
                min = classManager.get(i).getScore();
            }
        }
        System.out.println("平均分为：" + (sum-max-min) / (classManager.size() - 2));
    }
}
