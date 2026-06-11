package com.self.cinema.CinemaManage.Hall;
import com.self.cinema.CinemaManage.Devices.Device;
import com.self.cinema.CinemaManage.ScreenDays.ScreenDay;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hall implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L; // 必须添加
    private String hallName; //影厅名字唯一
    private int totalSeats; //影厅座位总数
    private Device device;//设备们
    private final List<ScreenDay> screenDays = new ArrayList<>();//影厅的每日场次

    public Hall(String hallName, int totalSeats) {
        this.hallName = hallName;
        this.totalSeats = totalSeats;
    }

    public void  printInfo(){
        System.out.println("影厅名=" + hallName + '\n' +
                "影厅座位总数=" + totalSeats);
    }



    public void setDevice(Device device) {
        this.device = device;
    }
    public Device getDevice() {
        return device;
    }

    public List<ScreenDay> getScreenDays() {
        return screenDays;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
