package com.self.oop_pro.InnerClass.AnonymousInnerClass;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    ArrayList<Student> classManager = new ArrayList<>();
    public void start(){
        StudentAdd addOperation = new StudentAdd(){//用于只有一个实现类的接口
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
                    operation(new StudentOperator() {
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
                    });
                    return;
                case "2" :
                    operation(new StudentOperator(){
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
                    });
                    return;
                default:
                    System.out.println("请输入正确的指令");
                    break;
            }
        }
    }

    public Manager(){

    }

    public void operation(StudentOperator operator){
        operator.printAll(classManager);
        operator.averageScore(classManager);
    }
    //一般用在java需要输入接口对象的api中，且该接口中已经有了方法，不需要写这一步，一般不主动使用
}
