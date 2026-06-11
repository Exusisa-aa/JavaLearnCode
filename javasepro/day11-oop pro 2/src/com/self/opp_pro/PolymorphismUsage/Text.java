package com.self.opp_pro.PolymorphismUsage;

public class Text {
    public static void main(String[] args) {
        People a1 = new Teacher();//对象多态
        a1.run();//行为多态
        People a2 = new Student();//对象多态
        a2.run();//行为多态
        People a3 = new Student();
//        Occupation a3 = new Teacher();  右边具有解耦性 便于维护与扩展




        go(a1);
        go(a2);
    }

    public static void go(People p){
        //定义方法时接收父类形参，可以接受一切子类对象，更便于拓展与维护
        if(p instanceof Student){
            Student p1 = (Student) p;
//            ((Student)p).text();
            p1.text();
        } else if (p instanceof Teacher) {
            Teacher p1= (Teacher) p;
//            ((Teacher)p).teach();
            p1.teach();
        }
    }
}
