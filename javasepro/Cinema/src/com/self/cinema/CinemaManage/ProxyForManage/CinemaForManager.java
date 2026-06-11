package com.self.cinema.CinemaManage.ProxyForManage;

import com.self.cinema.CinemaManage.Hall.Hall;

public interface CinemaForManager {
    void startSystemForManage();
    boolean managerLogin();
    void successLogin();
    void showHallInfo();
    void deviceDamageDeclare();
    void deviceRepairDeclare();
    void printHallInfo(Hall hall);

}
