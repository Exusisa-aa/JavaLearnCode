package com.self.hospitalRegister;

import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor {
    private String name;//医生的名字
    private String doctorId;//医生的id
    private int age;//医生的年龄
    private String departmentName;//医生所属科室
    private String gender;//医生性别
    private String speciality;//所属科室的专长
    private LocalDate joinDate;//入职时间
    private ArrayList<Schedule> schedules = new ArrayList<>();//装日程

    public Doctor() {
    }

    public Doctor(String name, String doctorId, int age, String departmentName, String gender, String speciality, LocalDate joinDate, ArrayList<Schedule> schedules) {
        this.name = name;
        this.doctorId = doctorId;
        this.age = age;
        this.departmentName = departmentName;
        this.gender = gender;
        this.speciality = speciality;
        this.joinDate = joinDate;
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
