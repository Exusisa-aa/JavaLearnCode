package com.self.oop_pro.ConstructorProblemExample;

public class Teacher extends People{
    private String skill;

    public Teacher() {
    }

    public Teacher(String skill){
        this.skill = skill;
    }

    public Teacher(String name,int age,String skill){
        super(name,age);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
