package com.self.oop.javabean;

public class StudentOperators {
    private Student student;

    public StudentOperators(Student student){
        this.student = student;
    }

    public void printPass(){
        if(this.student.getScore() >= 60) {
            System.out.println(this.student.getName() + "及格");
        }else {
            System.out.println(this.student.getName() + "不及格");
        }
    }

}
