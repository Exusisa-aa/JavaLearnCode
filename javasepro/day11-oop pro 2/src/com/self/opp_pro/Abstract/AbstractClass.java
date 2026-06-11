package com.self.opp_pro.Abstract;

public abstract class AbstractClass {//抽象类不一定有抽象方法，但有抽象方法一定有抽象类

    //抽象类不能创建方法,仅仅作为一种父类被子类继承并使用，且该子类必须重写父抽象类的全部方法，否则子类也要被定义为抽象类进而被继承

    private String name;
    private int age;
    private char sex;

    public AbstractClass() {
    }

    public AbstractClass(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public abstract void run();//抽象方法不能有方法体
}
