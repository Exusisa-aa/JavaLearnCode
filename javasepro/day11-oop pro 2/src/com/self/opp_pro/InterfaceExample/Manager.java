package com.self.opp_pro.InterfaceExample;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Student> classManager = new ArrayList<>();
    StudentOperator operator;
    public void start(){
        StudentAdd addOperation = new StudentAdd(){
            @Override
            public void add(ArrayList<Student> classManager){
                classManager.add(new Student("小明",'男',100));
                classManager.add(new Student("小刚",'男',95));
                classManager.add(new Student("小陈",'男',90));
                classManager.add(new Student("小红",'女',90));
                classManager.add(new Student("小绿",'女',85));
                classManager.add(new Student("小张",'男',70));
            }
        };
        addOperation.add(classManager);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================学生管理系统=================");
            System.out.println("输入1则应方案1进行查询");
            System.out.println("输入2则应方案2进行查询");
            System.out.println("请输入方案号：");
            String code = sc.next();
            switch (code){
                case "1" :
                    operator = new Operation1();
                    operator.printAll(classManager);
                    operator.averageScore(classManager);
                    return;
                case "2" :
                    operator = new Operation2();
                    operator.printAll(classManager);
                    operator.averageScore(classManager);
                    return;
                default:
                    System.out.println("请输入正确的指令");
                    break;
            }
        }
    }

    public Manager(){

    }
}
