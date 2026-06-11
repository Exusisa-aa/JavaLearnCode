package com.self.hospitalRegister;

import java.time.LocalDateTime;

public class Appointment {
    private String userName;//患者的名字
    private String sex;//患者的性别
    private String description;//患者病情自述
    private String departmentName;//患者所属的部门
    private String doctorId;//患者所属医生的id
    private LocalDateTime appointmentDateTime;//患者就诊时间
    private int age;//患者年龄

    public Appointment() {
    }

    public Appointment(String userName, String sex, String description, String departmentName, String doctorId, LocalDateTime appointmentDateTime, int age) {
        this.userName = userName;
        this.sex = sex;
        this.description = description;
        this.departmentName = departmentName;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
