package com.self.classHomework1;

import java.util.ArrayList;

public class PersonDate {
    private final ArrayList<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void printPersonalInfo() {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
