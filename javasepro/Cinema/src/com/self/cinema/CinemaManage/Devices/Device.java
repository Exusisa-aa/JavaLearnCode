package com.self.cinema.CinemaManage.Devices;

import java.io.Serializable;

public class Device implements Serializable {
    private String screenName;//屏幕型号
    private String projectorName;//放映机型号
    private String seatName;//座位型号
    private String airConditionName;//空调型号
    private String LightsName;//灯光型号
    private boolean isFixed;//是否需要维修
    private String mark;//报修备注

    public Device(String screenName, String projectorName, String seatName, String airConditionName, String lightsName, boolean isFixed, String mark) {
        this.screenName = screenName;
        this.projectorName = projectorName;
        this.seatName = seatName;
        this.airConditionName = airConditionName;
        LightsName = lightsName;
        this.isFixed = isFixed;
        this.mark = mark;
    }

    public void printInfo() {
        System.out.println("荧幕类型=" + screenName + '\n' +
                "投影仪类型=" + projectorName + '\n' +
                "座位参数=" + seatName + '\n' +
                "空调型号=" + airConditionName + '\n' +
                "灯光=" + LightsName + '\n' +
                "是否需要修理=" + isFixed + '\n' +
                "修理备注=" + mark);
    }

    public String message() {
        return  "1.荧幕类型=" + screenName + '\n' +
                "2.投影仪类型=" + projectorName + '\n' +
                "3.座位参数=" + seatName + '\n' +
                "4.空调型号=" + airConditionName + '\n' +
                "5.灯光=" + LightsName + '\n';
    }




    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public String getMark() {
        return mark;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setProjectorName(String projectorName) {
        this.projectorName = projectorName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public void setAirConditionName(String airConditionName) {
        this.airConditionName = airConditionName;
    }

    public void setLightsName(String lightsName) {
        LightsName = lightsName;
    }
}
