package com.self.hospitalRegister;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {
    private LocalDate today;//今日时间
    //上午
    private boolean morning;// 是否看诊
    private boolean morningIsUpdate;//是否排班
    private LocalTime morningStartTime;//上午排班开始时间
    private LocalTime morningEndTime;//上午排班结束时间
    private ArrayList<Appointment> morningPeople = new ArrayList<>();//上午已预约人数，装病人

    //下午
    private boolean afternoon;// 是否看诊
    private boolean afternoonIsUpdate;//是否排班
    private LocalTime afternoonStartTime;//上午排班开始时间
    private LocalTime afternoonEndTime;//上午排班结束时间
    private ArrayList<Appointment> AfternoonPeople = new ArrayList<>();//上午已预约人数，装病人

    public Schedule() {
    }

    public Schedule(LocalDate today, boolean morning, boolean morningIsUpdate, LocalTime morningStartTime, LocalTime morningEndTime, ArrayList<Appointment> morningPeople, boolean afternoon, boolean afternoonIsUpdate, LocalTime afternoonStartTime, LocalTime afternoonEndTime, ArrayList<Appointment> afternoonPeople) {
        this.today = today;
        this.morning = morning;
        this.morningIsUpdate = morningIsUpdate;
        this.morningStartTime = morningStartTime;
        this.morningEndTime = morningEndTime;
        this.morningPeople = morningPeople;
        this.afternoon = afternoon;
        this.afternoonIsUpdate = afternoonIsUpdate;
        this.afternoonStartTime = afternoonStartTime;
        this.afternoonEndTime = afternoonEndTime;
        AfternoonPeople = afternoonPeople;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isMorningIsUpdate() {
        return morningIsUpdate;
    }

    public void setMorningIsUpdate(boolean morningIsUpdate) {
        this.morningIsUpdate = morningIsUpdate;
    }

    public LocalTime getMorningStartTime() {
        return morningStartTime;
    }

    public void setMorningStartTime(LocalTime morningStartTime) {
        this.morningStartTime = morningStartTime;
    }

    public LocalTime getMorningEndTime() {
        return morningEndTime;
    }

    public void setMorningEndTime(LocalTime morningEndTime) {
        this.morningEndTime = morningEndTime;
    }

    public ArrayList<Appointment> getMorningPeople() {
        return morningPeople;
    }

    public void setMorningPeople(ArrayList<Appointment> morningPeople) {
        this.morningPeople = morningPeople;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public boolean isAfternoonIsUpdate() {
        return afternoonIsUpdate;
    }

    public void setAfternoonIsUpdate(boolean afternoonIsUpdate) {
        this.afternoonIsUpdate = afternoonIsUpdate;
    }

    public LocalTime getAfternoonStartTime() {
        return afternoonStartTime;
    }

    public void setAfternoonStartTime(LocalTime afternoonStartTime) {
        this.afternoonStartTime = afternoonStartTime;
    }

    public LocalTime getAfternoonEndTime() {
        return afternoonEndTime;
    }

    public void setAfternoonEndTime(LocalTime afternoonEndTime) {
        this.afternoonEndTime = afternoonEndTime;
    }

    public ArrayList<Appointment> getAfternoonPeople() {
        return AfternoonPeople;
    }

    public void setAfternoonPeople(ArrayList<Appointment> afternoonPeople) {
        AfternoonPeople = afternoonPeople;
    }
}

