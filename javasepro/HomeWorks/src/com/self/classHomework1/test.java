package com.self.classHomework1;

public class test {
    public static void main(String[] args) {
        Person person1 = new American("john","美国");
        Person person2 = new Chinese("张三","中国");
        Person person3 = new Indian("拉拉","印度");

        PersonDate personDate = new PersonDate();
        personDate.addPerson(person1);
        personDate.addPerson(person2);
        personDate.addPerson(person3);

        personDate.printPersonalInfo();
    }
}
