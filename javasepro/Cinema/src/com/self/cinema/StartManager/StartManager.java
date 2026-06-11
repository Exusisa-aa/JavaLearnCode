package com.self.cinema.StartManager;

import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.ProxyForManage.CinemaForManager;
import com.self.cinema.CinemaManage.ProxyForManage.ProxyForManage;


public class StartManager {
    //CinemaManagerManagement 的动态代理
    public static CinemaManagerManagement cinemaManager = new CinemaManagerManagement();
    public static CinemaForManager proxyForManage = ProxyForManage.createProxy(cinemaManager);

    public static void main(String[] args) {
        //管理员系统单线程即可
        proxyForManage.startSystemForManage();

    }

}
