package com.self.cinema.CinemaManage;

import com.self.cinema.CinemaManage.Hall.Hall;
import com.self.cinema.CinemaManage.ProxyForManage.CinemaForManager;
import com.self.cinema.CinemaManage.ProxyForManage.ProxyForManage;
import com.self.cinema.CinemaManage.ScreenDays.ScreenDay;
import com.self.cinema.CinemaManage.ScreenDays.ScreenTimes.ScreenTime;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.MyUtils;
import com.self.cinema.StartManager.StartManager;
import com.self.cinema.StartWorker.StartWorker;


import java.io.*;
import java.util.*;

public class CinemaManagerManagement implements CinemaForManager {
    private final String NAME = "光明影城"; //电影院名字
    public static List<Hall> cinema = new ArrayList<>(); //电影院


    //管理员不需要锁对象，单线程


    //manager.txt路径
    private static final String filePath = FilePath.CINEMA_PATH_TO_TXT.getPath();

    static {
        LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();//更新电影院信息
        updateCinema();
        flushCinema();//!!!加速其他类访问cinema集合
    }
    @Override
    public void startSystemForManage() {
        Scanner sc = new Scanner(System.in);
        String command;//指令
        System.out.println("------------------------" + NAME + "管理员欢迎您" + "------------------------");
        while (true){
            System.out.println("1.登录");
            System.out.println("2.退出");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    if(StartManager.proxyForManage.managerLogin()){
                        StartManager.proxyForManage.successLogin();
                    }
                    return;
                case "2":
                    System.out.println("已退出系统，欢迎下次再来~~");
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    @Override
    public boolean managerLogin(){
        String userName;
        String password;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入管理员账号：  (输入exit退出登录)" );
            userName = sc.nextLine();
            if(Objects.equals(userName, ManagerAccountMessage.MANAGER.getUserName())){
                System.out.println("请输入密码：");
                password = sc.nextLine();
                if(Objects.equals(password, ManagerAccountMessage.MANAGER.getPassword())){
                    System.out.println("登录成功！");
                    return true;
                } else if (Objects.equals(password,"exit")) {
                    return false;
                } else {
                    System.out.println("您输入的密码有误，请重新输入：");
                }
            } else if (Objects.equals(userName,"exit")) {
                return false;
            } else {
                System.out.println("您输入的账号有误，请重新输入：");
            }
        }
    }

    @Override
    public void successLogin(){
        System.out.println("------------------------管理员，您好------------------------");
        Scanner sc = new Scanner(System.in);
        String command;//指令
        while (true){
            System.out.println("1.更新系统的全部信息");
            System.out.println("2.查看厅信息");
            System.out.println("3.设备损坏申报");
            System.out.println("4.设备已维修，取消申报");
            System.out.println("5.添加员工");
            System.out.println("6.员工加薪");
            System.out.println("7.解雇员工");
            System.out.println("8.查找员工信息");
            System.out.println("9.查看员工的请假请求");
            System.out.println("10.退出管理员系统");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();
                    System.out.println("成功更新系统信息~~");
                    break;
                case "2":
                    StartManager.proxyForManage.showHallInfo();
                    break;
                case "3":
                    StartManager.proxyForManage.deviceDamageDeclare();
                    break;
                case "4":
                    StartManager.proxyForManage.deviceRepairDeclare();
                    break;
                case "5":
                    StartWorker.proxyForWorker.addWorker();
                    break;
                case "6":
                    StartWorker.proxyForWorker.increaseSalary();
                    break;
                case "7":
                    StartWorker.proxyForWorker.fireWorker();
                    break;
                case "8":
                    StartWorker.proxyForWorker.showWorkerInfo();
                    break;
                case "9":
                    StartWorker.proxyForWorker.printLeaveApplications();
                    break;
                case "10":
                    System.out.println("欢迎下次光临~~");
                    ProxyForManage.LOGGER.info("{}退出登录", ManagerAccountMessage.MANAGER.getUserName());
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    @Override
    public void showHallInfo(){
        int command = 0;//指令
        while (true) {
            System.out.println("0:返回上一级");
            for (int i = 0; i < cinema.size(); i++) {
                System.out.println((i+1) + ":" + cinema.get(i).getHallName());
            }
            System.out.println("请输入厅号：");
            try {
                command = MyUtils.intInput();
            }catch (Exception e){
                System.out.println("请输入纯数字");
            }
            if(command > 0 && command <= cinema.size()){
                printHallInfo(cinema.get(command - 1));
                break;
            } else if (command == 0) {
                return;
            } else {
                System.out.println("您输入的厅号有误，请重新输入：");
            }
        }
    }


    @Override
    public void deviceDamageDeclare(){
        Scanner sc = new Scanner(System.in);
        String mark;
        int command0 = 0;//指令 厅号
        int command1 = 0;//指令 设备号
        while (true) {
            System.out.println("0:返回上一级");
            for (int i = 0; i < cinema.size(); i++) {
                System.out.println((i+1) + ":" + cinema.get(i).getHallName());
            }
            System.out.println("请输入厅号：");
            try {
                command0 = MyUtils.intInput();
            }catch (Exception e){
                System.out.println("请输入纯数字");
            }
            if(command0 > 0 && command0 <= cinema.size()){
                System.out.println("0:返回上一级");
                System.out.println(cinema.get(command0 - 1).getDevice().message());
                while (true){
                    System.out.println("请输入设备号：");
                    try {
                        command1 = MyUtils.intInput();
                    }catch (Exception e){
                        System.out.println("请输入纯数字");
                    }
                    if(command1 > 0 && command1 <= cinema.getClass().getDeclaredFields().length - 1){
                        System.out.println("请输入备注：");
                        mark = sc.nextLine();
                        LoadAndUpdateCinemaMessage.updateDeviceInfo(true,mark,command0);
                        return;
                    }else if (command1 == 0) {
                        StartManager.proxyForManage.deviceDamageDeclare();
                        return;
                    } else {
                        System.out.println("您输入的设备号有误，请重新输入：");
                    }
                }
            } else if (command0 == 0) {
                return;
            } else {
                System.out.println("您输入的厅号有误，请重新输入：");
            }
        }
    }

    @Override
    public void deviceRepairDeclare(){
        int command0 = 0;//指令 厅号
        while (true) {
            System.out.println("0:返回上一级");
            for (int i = 0; i < cinema.size(); i++) {
                System.out.println((i+1) + ":" + cinema.get(i).getHallName());
            }
            System.out.println("请输入厅号：");
            try {
                command0 = MyUtils.intInput();
            }catch (Exception e){
                System.out.println("请输入纯数字");
            }
            if(command0 > 0 && command0 <= cinema.size()){
                LoadAndUpdateCinemaMessage.updateDeviceInfo(false,"NULL",command0);
                System.out.println("已成功撤回申报~~");
                return;
            } else if (command0 == 0) {
                return;
            } else {
                System.out.println("您输入的厅号有误，请重新输入：");
            }
        }
    }

    @Override
    public void printHallInfo(Hall hall){
        //在开头的refresh不在需要flush，因为在代理中已经做过了
        hall = returnNewHall(hall);
        assert hall != null;


        hall.printInfo();
        hall.getDevice().printInfo();
        System.out.println("{");
        for (ScreenDay screenDay : hall.getScreenDays()) {
            screenDay.printInfo();
            System.out.println("{");
            for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                screenTime.printInfo();
            }
            System.out.println("}");
        }
        System.out.println("}");
    }


    //io流的目的：实现快速传递cinema集合  已达到实时更新  该io流供其他类访问cinema集合时使用
    public static void updateCinema(){
        try {
            LockForThread.INSTANCE.getLock().lock();
            //清空数据并对象序列化
            try(
                    FileOutputStream fos = new FileOutputStream(filePath,false);
                    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))
            ) {
                oos.writeObject(cinema);
                //刷新流
                oos.flush();
                //刷新后同步到硬盘，强制缓冲流刷新
                fos.getFD().sync();
            }catch (Exception e){
                e.getStackTrace();
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }

    public static void flushCinema(){
        try {
            LockForThread.INSTANCE.getLock().lock();
            //刷新后重载数据到workers中
            if (new File(filePath).length() != 0) {
                try (
                        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))
                ) {
                    cinema = (List<Hall>) ois.readObject();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }

    public static Hall returnNewHall(Hall oldHall){
        for (Hall newHall : cinema) {
            if(Objects.equals(oldHall.getHallName(),newHall.getHallName())){
                return newHall;
            }
        }
        return null;
    }





}
