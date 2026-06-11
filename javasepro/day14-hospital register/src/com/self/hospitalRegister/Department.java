package com.self.hospitalRegister;

import java.util.ArrayList;

public class Department {
    private String name;//部门名字
    private ArrayList<Doctor> doctors = new ArrayList<>();//装医生

    public Department() {
    }

    public Department(String name, ArrayList<Doctor> doctors) {
        this.name = name;
        this.doctors = doctors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
}
