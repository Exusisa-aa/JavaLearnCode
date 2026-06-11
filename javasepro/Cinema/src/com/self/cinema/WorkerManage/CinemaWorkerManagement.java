package com.self.cinema.WorkerManage;


import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.Hall.Hall;
import com.self.cinema.CinemaManage.ScreenDays.ScreenDay;
import com.self.cinema.CinemaManage.ScreenDays.ScreenTimes.ScreenTime;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.MyUtils;
import com.self.cinema.StartWorker.StartWorker;
import com.self.cinema.WorkerManage.ProxyForManage.CinemaForWorker;
import com.self.cinema.WorkerManage.ProxyForManage.ProxyForWorker;
import com.self.cinema.WorkerManage.WorkDays.WorkDay;
import com.self.cinema.WorkerManage.WorkDays.WorkTimes.WorkTime;
import com.self.cinema.WorkerManage.Workers.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CinemaWorkerManagement implements CinemaForWorker {
    public static LinkedHashSet<Worker> workers = new LinkedHashSet<>();


    //workers.txt路径
    private static final String filePath = FilePath.WORKER_PATH_TO_TXT.getPath();
    //IO流引入workers集合数据
    static {
        if (new File(filePath).length() != 0 ) {
            try (
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))
            ) {
                workers = (LinkedHashSet<Worker>) ois.readObject();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        //更新cinema
        CinemaManagerManagement.flushCinema();
    }


    @Override
    public void startSystemForWorker(){
        Scanner sc = new Scanner(System.in);
        String command;//指令
        System.out.println("------------------------影院工作人员管理系统------------------------");
        while (true){
            System.out.println("1.登录");
            System.out.println("2.退出");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    Worker worker = StartWorker.proxyForWorker.workerLogin();
                    if(worker != null){
                        StartWorker.proxyForWorker.successLogin(worker);
                    }
                    break;
                case "2":
                    System.out.println("已退出系统，欢迎下次再来~~");
                    ProxyForWorker.LOGGER.info("员工已退出系统");
                    try {
                        updateIOsAndLog();
                        LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    @Override
    public Worker workerLogin(){
        String userName;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入工号: exit退出");
        userName = sc.nextLine();
        if(Objects.equals("exit", userName)){
            return null;
        }
        for (Worker worker : workers) {
            if(Objects.equals(userName, worker.getWorkCode())){
                while (true) {
                    System.out.println("请输入密码： exit退出");
                    password = sc.nextLine();
                    if(Objects.equals("exit", password)){
                        return null;
                    }
                    if(Objects.equals(password, worker.getPassword())){
                        System.out.println("登陆成功！");
                        return worker;
                    }else {
                        System.out.println("密码错误！");
                    }
                }
            }
        }
        System.out.println("未找到该工号~~");
        return null;

    }

    @Override
    public void successLogin(Worker worker){
        updateWorker(worker.getWorkType(),worker,false);
        System.out.println("------------------------员工" + worker.getName() + "您好,欢迎进入工作系统------------------------");
        Scanner sc = new Scanner(System.in);
        String command;//指令
        while (true){
            System.out.println("1.查看今日与未来五天的工作");
            System.out.println("2.修改密码");
            System.out.println("3.请假与查看请假记录");
            System.out.println("4.退出登录");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    //刷新影院信息
                    //从另一个类的集合获取信息的方法
                    CinemaManagerManagement.flushCinema();
                    //同步
                    flushIOAndLog();
                    worker = refreshWorker(worker);
                    //更新员工信息
                    if (worker != null) {
                        StartWorker.proxyForWorker.updateWorker(worker.getWorkType(),worker,false);
                        worker.printWorkInfo();
                    }
                    break;
                case "2":
                    boolean flag = StartWorker.proxyForWorker.changePassword(worker);
                    if(flag){
                        return;
                    }else {
                        break;
                    }
                case "3":
                    boolean flag1 = StartWorker.proxyForWorker.leaveApplicate(worker);
                    if(flag1){
                        break;
                    }else {
                        return;
                    }
                case "4":
                    System.out.println("已退出登录，欢迎下次在来~~");
                    if (worker != null) {
                        ProxyForWorker.LOGGER.info("{}退出登录", worker.getName());
                    }
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    @Override
    public boolean changePassword(Worker worker){
        try {
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            worker = refreshWorker(worker);
            assert worker != null;//断言
            Scanner sc = new Scanner(System.in);
            String password;
            String passwordConfirm;
            while (true) {
                System.out.println("请您输入新的账户密码： exit退出");
                password = sc.nextLine();
                if (Objects.equals(password,worker.getPassword())) {
                    System.out.println("您不能输入很您的账户密码相同的密码~~");
                } else if(password.matches("[0-9a-zA-Z]{5,20}")){
                    System.out.println("请再次输入新的账户密码： exit退出");
                    passwordConfirm = sc.nextLine();
                    if(Objects.equals(passwordConfirm,password)){
                        worker.getLock().lock();
                        System.out.println("修改成功~~请重新登录");
                        worker.setPassword(passwordConfirm);
                        return true;
                    } else if (Objects.equals("exit",passwordConfirm)) {
                        return false;
                    }else {
                        System.out.println("您输入的两次密码不一致，请重新确认！");
                    }
                } else if (Objects.equals("exit",password)) {
                    return false;
                }else {
                    System.out.println("请输入数字或字母！且长度位于5到20位之间");
                }
            }
        } finally {
            assert worker != null;
            if(worker.getLock().tryLock()){
                worker.getLock().unlock();
            }
        }
    }

    @Override
    public boolean leaveApplicate(Worker worker){
        try {
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            worker = refreshWorker(worker);
            assert worker != null;//断言
            Scanner sc = new Scanner(System.in);
            String command;
            String leaveDate;
            String reason;
            int index;

            if(worker.getWorkDays().isEmpty()){
                System.out.println("您并没有排班信息~~");
                successLogin(worker);
                return true;
            }
            while (true){
                System.out.println("0.返回上一级");
                System.out.println("1.请假");
                System.out.println("2.查看申请");
                System.out.println("请输入指令：");
                command = sc.nextLine();
                if(Objects.equals("0",command)){
                    successLogin(worker);
                    return false;
                } else if (Objects.equals("1",command)) {
                    OUT:
                    while(true){
                        System.out.println("请输入请假的日期：(yyyy-MM-dd)  exit退出");
                        leaveDate = sc.nextLine();
                        if(leaveDate.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && worker != null){
                            for (WorkDay workDay : worker.getWorkDays()) {
                                if(Objects.equals(workDay.getWorkDate(), LocalDate.parse(leaveDate))){
                                    System.out.println("请输入请假理由： exit退出");
                                    reason = sc.nextLine();
                                    if(Objects.equals("exit",reason)){
                                        break OUT;
                                    }
                                    worker.getLock().lock();
                                    index = worker.getLeaveApplications().size() + 1;
                                    worker.getLeaveApplications().put(index,"申请中,理由:" + reason + ",申请的日期:" + leaveDate);
                                    System.out.println("申请成功~~");
                                    //刷新workers
                                    updateIOsAndLog();
                                    LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                    //拿出新的worker
                                    worker = refreshWorker(worker);
                                    break OUT;
                                }
                            }
                            System.out.println("这个日期上并没有您的排班~~");

                        } else if (Objects.equals("exit",leaveDate)) {
                            break;
                        } else {
                            System.out.println("请输入正确的时间~~");
                        }
                    }
                } else if (Objects.equals("2",command)) {
                    //以下两条一起搭配则能及时更新
                    //先刷新workers
                    flushIOAndLog();
                    //再从新workers里把新worker拿出来
                    worker = refreshWorker(worker);


                    var ref = new Object() {
                        int i = 0;
                    };
                    if (worker != null && !worker.getLeaveApplications().isEmpty()) {
                        Worker finalWorker = worker;
                        worker.getLeaveApplications().forEach((k, v) -> {
                            ref.i++;
                            System.out.println(k + "." + v);
                            if (ref.i == finalWorker.getLeaveApplications().size()) {
                                System.out.println(" ");
                            }
                        });
                        StartWorker.proxyForWorker.leaveApplicate(worker);

                        return false;
                    }else {
                        System.out.println("您并没有请假的记录~~");
                    }
                } else{
                    System.out.println("您输入的指令有误！");
                }
            }
        } finally {
            assert worker != null;
            if(worker.getLock().tryLock()){
                worker.getLock().unlock();
            }
        }
    }




    //以上为工作人员的启动方法
    //以下为管理员所调用的方法
    @Override
    public void addWorker(){
        String name;
        String gender;
        String phone;
        String password;
        String passwordConfirm;
        double salary;
        String workCode;
        String workType;
        Scanner sc = new Scanner(System.in);
        //输入姓名
        System.out.println("请输入员工姓名： exit退出");
        while (true) {
            name = sc.nextLine();
            if (Objects.equals("exit",name)){
                return;
            } else if (name.matches("^[\\u4e00-\\u9fa5A-Za-z ]+$")) {
                break;
            } else {
                System.out.println("用户名必须是英文或字母的组合，请重新输入：");
            }
        }
        //输入性别
        System.out.println("请输入员工性别： exit退出");
        while (true) {
            gender = sc.nextLine();
            if(Objects.equals("男",gender) || Objects.equals("女",gender)){
                break;
            } else if (Objects.equals("exit",gender)) {
                return;
            }else {
                System.out.println("您输入的性别有误，请重新输入：");
            }
        }
        //输入电话
        System.out.println("请输入员工电话： exit退出");
        while (true){
            phone = sc.nextLine();
            if (phone.matches("1[3-9]\\d{9}")){
                break;
            } else if (Objects.equals("exit",phone)) {
                return;
            }else {
                System.out.println("您输入的电话有误，请重新输入：");
            }
        }
        //输入密码
        while (true) {
            System.out.println("请您输入账户密码： exit退出");
            password = sc.nextLine();
            if(password.matches("[0-9a-zA-Z]{5,20}")){
                System.out.println("请再次输入您的账户密码： exit退出");
                passwordConfirm = sc.nextLine();
                if(Objects.equals(passwordConfirm,password)){
                    break;
                } else if (Objects.equals("exit",passwordConfirm)) {
                    return;
                }else {
                    System.out.println("您输入的两次密码不一致，请重新确认！");
                }
            } else if (Objects.equals("exit",password)) {
                return;
            }else {
                System.out.println("请输入数字或字母！且长度位于5到20位之间");
            }
        }
        //生成工号
        workCode = MyUtils.randomUUID().toString();
        //输入薪水
        while (true){
            System.out.println("请您输入员工薪水：");
            try {
                salary = MyUtils.doubleInput();
                break;
            }catch (Exception e){
                System.out.println("请输入纯数字");
            }
        }
        //选择职业
        while (true){
            System.out.println("请选择职业：(" + WorkType.FRONTDESKER.getWorkType() + "),(" + WorkType.MAINTAINER.getWorkType() + "),(" + WorkType.MOVIEPLAYER.getWorkType() + "),(" + WorkType.CLEANER.getWorkType() + ")  exit退出");
            workType = sc.nextLine();
            if(Objects.equals(WorkType.FRONTDESKER.getWorkType(),workType)){

                Worker worker = new FrontDesker(workType,workCode,name,gender,phone,password,salary);
                StartWorker.proxyForWorker.updateWorker(workType,worker,true);
                workers.add(worker);
                System.out.println("添加成功，该员工的工号为" + worker.getWorkCode() + "，请牢记！");
                break;
            } else if (Objects.equals(WorkType.MAINTAINER.getWorkType(),workType)){
                Worker worker = new Maintainer(workType,workCode,name,gender,phone,password,salary);
                StartWorker.proxyForWorker.updateWorker(workType,worker,true);
                workers.add(worker);
                System.out.println("添加成功，该员工的工号为" + worker.getWorkCode() + "，请牢记！");
                break;
            } else if (Objects.equals(WorkType.MOVIEPLAYER.getWorkType(),workType)){
                Worker worker = new MoviePlayer(workType,workCode,name,gender,phone,password,salary);
                StartWorker.proxyForWorker.updateWorker(workType,worker,true);
                workers.add(worker);
                System.out.println("添加成功，该员工的工号为" + worker.getWorkCode() + "，请牢记！");
                break;
            } else if (Objects.equals(WorkType.CLEANER.getWorkType(),workType)){
                Worker worker = new Cleaner(workType,workCode,name,gender,phone,password,salary);
                StartWorker.proxyForWorker.updateWorker(workType,worker,true);
                workers.add(worker);
                System.out.println("添加成功，该员工的工号为" + worker.getWorkCode() + "，请牢记！");
                break;
            }  else if (Objects.equals("exit",workType)) {
                return;
            }else {
                System.out.println("输入有误，请重新输入~~");
            }
        }
    }

    @Override
    public void increaseSalary() {
        String workCodeInput;
        boolean flag = true;
        String confirm;
        double money;
        if(workers.isEmpty()){
            System.out.println("还没有员工，先添加员工~");
            return;
        }
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入员工工号:  exit退出");
            workCodeInput = sc.nextLine();
            if(Objects.equals(workCodeInput, "exit")){
                return;
            }
            OUT:
            for (Worker worker : workers) {
                if(Objects.equals(workCodeInput, worker.getWorkCode())){
                    flag = false;
                    System.out.println(worker.getWorkType());
                    System.out.println(worker.getWorkCode());
                    System.out.println(worker.getName());
                    System.out.println(worker.getGender());
                    System.out.println(worker.getSalary());
                    System.out.println("请输入加薪金额：");
                    while (true) {
                        try {
                            money = MyUtils.doubleInput();
                            break;
                        }catch (Exception e){
                            System.out.println("请输入正确的数字：");
                        }
                    }
                    System.out.println("您确定要给该员工加薪吗？ y/n");
                    while (true){
                        confirm = sc.nextLine();
                        if(Objects.equals(confirm, "y")){
                            try {
                                worker.getLock().lock();
                                System.out.println("好的~已加薪~");
                                worker.setSalary(worker.getSalary() + money);
                                break OUT;
                            } finally {
                                if(worker.getLock().tryLock()){
                                    worker.getLock().unlock();
                                }
                            }
                        } else if (Objects.equals(confirm,"n")) {
                            System.out.println("好的~已撤回~");
                            break OUT;
                        } else {
                            System.out.println("输入有误，请重新输入:");
                        }
                    }
                }
            }
            if(flag){
                System.out.println("未找到该员工~");
            }else {
                return;
            }
        }
    }

    //一个小的补丁(牺牲性能，减少调用)
    public void updateAll(){
        for (Worker worker : workers) {
            updateWorker(worker.getWorkType(),worker,false);
        }
        LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
    }


    @Override
    public void updateWorker(String workType,Worker worker,boolean isAdd){
        try {
            //isAdd  是否是第一次添加
            Scanner sc = new Scanner(System.in);
            String workPlace = "";
            int rememberHall = 0;
            ArrayList<LocalDate> rememberLeave = new ArrayList<>();
            if (!worker.getWorkDays().isEmpty()) {
                for (WorkTime workTime : worker.getWorkDays().get(0).getWorkTimes()) {
                    if(!workTime.getWorkHall().isEmpty()){
                        workPlace = workTime.getWorkHall();
                        if(worker.getWorkType().equals(WorkType.MOVIEPLAYER.getWorkType()) || worker.getWorkType().equals(WorkType.CLEANER.getWorkType())){
                            rememberHall = Integer.parseInt(workPlace.substring(0,1));
                        }
                    }
                }
                for (WorkDay workDay : worker.getWorkDays()) {
                    if(workDay.isLeave()){
                        rememberLeave.add(workDay.getWorkDate());
                    }
                }
            }
            if(!worker.getWorkDays().isEmpty()){
                worker.getWorkDays().clear();
            }
            if(Objects.equals(WorkType.FRONTDESKER.getWorkType(),workType)){
                if (isAdd) {
                    while (true) {
                        System.out.println("请输入该员工的主要职责： (前台售卖 前台入场 前台通知)");
                        workPlace = sc.nextLine();
                        if (workPlace.equals("前台售卖") || workPlace.equals("前台入场") || workPlace.equals("前台通知")) {
                            break;
                        } else {
                            System.out.println("输入有误，请重新输入~~");
                        }
                    }
                }
                for (ScreenDay screenDay : CinemaManagerManagement.cinema.get(1).getScreenDays()) {
                    worker.getLock().lock();
                    WorkDay workDay = new WorkDay();
                    WorkTime workTime = new WorkTime(LocalTime.of(8,0,0),LocalTime.of(23,50,0),workPlace);
                    if (!rememberLeave.isEmpty()) {
                        for (LocalDate localDate : rememberLeave) {
                            if(Objects.equals(localDate,screenDay.getDateInfo())){
                                workDay = new WorkDay(screenDay.getDateInfo(),true);
                                break;
                            }else {
                                workDay = new WorkDay(screenDay.getDateInfo(),false);
                            }
                        }
                    }else {
                        workDay = new WorkDay(screenDay.getDateInfo(),false);
                    }
                    workDay.getWorkTimes().add(workTime);
                    worker.getWorkDays().add(workDay);
                }
            } else if (Objects.equals(WorkType.MAINTAINER.getWorkType(),workType)) {
                worker.getLock().lock();
                for (Hall hall : CinemaManagerManagement.cinema) {
                    if(hall.getDevice().isFixed()){
                        WorkTime workTime = new WorkTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS),LocalTime.of(23,50,0),hall.getHallName() + "\t" +hall.getDevice().getMark());
                        WorkDay workDay = new WorkDay(LocalDate.now(),false);
                        if (!rememberLeave.isEmpty()) {
                            for (LocalDate localDate : rememberLeave) {
                                if(Objects.equals(localDate,workDay.getWorkDate())){
                                    workDay = new WorkDay(localDate,true);
                                    break;
                                }
                            }
                        }else {
                            workDay  = new WorkDay(workDay.getWorkDate(),false);
                        }
                        workDay.getWorkTimes().add(workTime);
                        worker.getWorkDays().add(workDay);
                    }
                    for (WorkDay workDay : worker.getWorkDays()) {
                        for (WorkTime workTime : workDay.getWorkTimes()) {
                            if(Objects.equals(workTime.getWorkHall(),hall.getHallName())  &&  !hall.getDevice().isFixed()){
                                worker.getWorkDays().remove(workDay);
                            }
                        }
                    }
                }
            } else if (Objects.equals(WorkType.MOVIEPLAYER.getWorkType(),workType)) {
                if (isAdd) {
                    while (true) {
                        System.out.println("请输入该员工的负责影院");
                        for (int i = 0; i < CinemaManagerManagement.cinema.size(); i++) {
                            System.out.println((i + 1) + ":" + CinemaManagerManagement.cinema.get(i).getHallName());
                        }
                        workPlace = sc.nextLine();
                        if (workPlace.equals("1") || workPlace.equals("2") || workPlace.equals("3") || workPlace.equals("4") || workPlace.equals("5") || workPlace.equals("6")) {
                            rememberHall = Integer.parseInt(workPlace);
                            break;
                        } else {
                            System.out.println("输入有误，请重新输入~~");
                        }
                    }
                }
                for (ScreenDay screenDay : CinemaManagerManagement.cinema.get(rememberHall - 1).getScreenDays()) {
                    worker.getLock().lock();
                    WorkDay workDay = new WorkDay();
                    if (!rememberLeave.isEmpty()) {
                        for (LocalDate localDate : rememberLeave) {
                            if(Objects.equals(localDate,screenDay.getDateInfo())){
                                workDay = new WorkDay(screenDay.getDateInfo(),true);
                                break;
                            }else {
                                workDay = new WorkDay(screenDay.getDateInfo(),false);
                            }
                        }
                    }else {
                        workDay = new WorkDay(screenDay.getDateInfo(),false);
                    }
                    for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                        WorkTime workTime = new WorkTime(screenTime.getStartTime().minusMinutes(10), screenTime.getStartTime(), CinemaManagerManagement.cinema.get(rememberHall - 1).getHallName());
                        workDay.getWorkTimes().add(workTime);
                    }
                    worker.getWorkDays().add(workDay);
                }
            } else if (Objects.equals(WorkType.CLEANER.getWorkType(),workType)) {
                if (isAdd) {
                    while (true) {
                        System.out.println("请输入该员工的负责影院");
                        for (int i = 0; i < CinemaManagerManagement.cinema.size(); i++) {
                            System.out.println((i + 1) + ":" + CinemaManagerManagement.cinema.get(i).getHallName());
                        }
                        workPlace = sc.nextLine();
                        if (workPlace.equals("1") || workPlace.equals("2") || workPlace.equals("3") || workPlace.equals("4") || workPlace.equals("5") || workPlace.equals("6")) {
                            rememberHall = Integer.parseInt(workPlace);
                            break;
                        } else {
                            System.out.println("输入有误，请重新输入~~");
                        }
                    }
                }
                for (ScreenDay screenDay : CinemaManagerManagement.cinema.get(rememberHall - 1).getScreenDays()) {
                    worker.getLock().lock();
                    WorkDay workDay = new WorkDay();
                    if (!rememberLeave.isEmpty()) {
                        for (LocalDate localDate : rememberLeave) {
                            if(Objects.equals(localDate,screenDay.getDateInfo())){
                                workDay = new WorkDay(screenDay.getDateInfo(),true);
                                break;
                            }else {
                                workDay = new WorkDay(screenDay.getDateInfo(),false);
                            }
                        }
                    }else {
                        workDay = new WorkDay(screenDay.getDateInfo(),false);
                    }
                    for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                        WorkTime workTime = new WorkTime(screenTime.getEndTime(), screenTime.getEndTime().plusMinutes(10), CinemaManagerManagement.cinema.get(rememberHall - 1).getHallName());
                        workDay.getWorkTimes().add(workTime);
                    }
                    worker.getWorkDays().add(workDay);
                }
            } else {
                System.out.println("信息有误,无法更新信息");
            }
            worker.getWorkDays().sort(Comparator.comparing(WorkDay::getWorkDate));
        } finally {
            assert worker != null;
            if(worker.getLock().tryLock()){
                worker.getLock().unlock();
            }
        }
    }


    @Override
    public void fireWorker(){
        String workCodeInput;
        boolean flag = true;
        String confirm;
        if(workers.isEmpty()){
            System.out.println("还没有员工，先添加员工~");
            return;
        }
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入员工工号:  exit退出");
            workCodeInput = sc.nextLine();
            if(Objects.equals(workCodeInput, "exit")){
                return;
            }
            OUT:
            for (Worker worker : workers) {
                if(Objects.equals(workCodeInput, worker.getWorkCode())){
                    flag = false;
                    System.out.println("确定要解雇该员工吗？ y/n");
                    while (true){
                        confirm = sc.nextLine();
                        if(Objects.equals(confirm, "y")){
                            try {
                                worker.getLock().lock();
                                System.out.println("好的~已解雇~");
                                workers.remove(worker);
                                break OUT;
                            } finally {
                                if(worker.getLock().tryLock()){
                                    worker.getLock().unlock();
                                }
                            }
                        } else if (Objects.equals(confirm,"n")) {
                            System.out.println("好的~已保留~");
                            break OUT;
                        } else {
                            System.out.println("输入有误，请重新输入:");
                        }
                    }
                }
            }
            if(flag){
                System.out.println("未找到该员工~");
            }else {
                return;
            }
        }
    }

    @Override
    public void showWorkerInfo(){
        String workCodeInput;
        boolean flag = true;
        if(workers.isEmpty()){
            System.out.println("还没有员工，先添加员工~");
            return;
        }
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入员工工号:  exit退出");
            workCodeInput = sc.nextLine();
            if(Objects.equals(workCodeInput, "exit")){
                return;
            }
            for (Worker worker : workers) {
                if(Objects.equals(workCodeInput, worker.getWorkCode())){
                    //更新员工信息
                    StartWorker.proxyForWorker.updateWorker(worker.getWorkType(),worker,false);

                    flag = false;
                    worker.printWorkInfo();
                    break;
                }
            }
            if(flag){
                System.out.println("未找到该员工~");
            }else {
                return;
            }
        }
    }

    @Override
    public void printLeaveApplications(){
        Scanner sc = new Scanner(System.in);
        int command = 0;
        String confirm;
        for (Worker worker : workers) {
            if (!worker.getLeaveApplications().isEmpty() && worker.getLeaveApplications().entrySet().stream().filter(ele -> ele.getValue().contains("已批准")).count() + worker.getLeaveApplications().entrySet().stream().filter(ele -> ele.getValue().contains("已拒绝")).count() != worker.getLeaveApplications().size()) {
                while (true) {
                    System.out.println(worker.getName());
                    System.out.println(worker.getWorkCode());
                    System.out.println(worker.getWorkType());
                    if (!worker.getWorkDays().isEmpty()) {
                        worker.getWorkDays().get(0).getWorkTimes().stream().limit(1).forEach(ele -> System.out.println("负责区域" + ele.getWorkHall()));
                    }
                    worker.getLeaveApplications().entrySet()
                            .stream().filter(ele -> ele.getValue().contains("申请中"))
                            .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey())).forEach(ele -> {
                                System.out.println(ele.getKey() + ".请假时间:" + ele.getValue().substring(ele.getValue().length() - 10));
                                System.out.println("请假理由:" + ele.getValue().substring(7, ele.getValue().length() - 17));
                            });
                    System.out.println("请输入号数：");
                    try {
                        command = MyUtils.intInput();
                    } catch (Exception e) {
                        System.out.println("只能输入数字~~");
                    }
                    if (command >= worker.getLeaveApplications().entrySet().stream().filter(ele -> ele.getValue().contains("申请中")).findFirst().get().getKey() && command <= worker.getLeaveApplications().size()) {
                        while (true) {
                            System.out.println("是否同意该员工请假申请？ y/n ");
                            confirm = sc.nextLine();
                            if (Objects.equals(confirm, "y")) {
                                System.out.println("已同意请假~~");
                                worker.getLeaveApplications().put(command, "已批准,理由:" + worker.getLeaveApplications().get(command).substring(7, worker.getLeaveApplications().get(command).length() - 17) + ",申请的日期:" + worker.getLeaveApplications().get(command).substring(worker.getLeaveApplications().get(command).length() - 10));
                                for (WorkDay workDay : worker.getWorkDays()) {
                                    if (Objects.equals(workDay.getWorkDate(), LocalDate.parse(worker.getLeaveApplications().get(command).substring(worker.getLeaveApplications().get(command).length() - 10)))) {
                                        workDay.setLeave(true);
                                        updateWorker(worker.getWorkType(), worker, false);
                                        return;
                                    }
                                }
                            } else if (Objects.equals(confirm, "n")) {
                                System.out.println("已拒绝请假~~");
                                worker.getLeaveApplications().put(command, "已拒绝,理由:" + worker.getLeaveApplications().get(command).substring(7, worker.getLeaveApplications().get(command).length() - 17) + ",申请的日期:" + worker.getLeaveApplications().get(command).substring(worker.getLeaveApplications().get(command).length() - 10));
                                updateWorker(worker.getWorkType(), worker, false);
                                return;
                            } else {
                                System.out.println("您输入的指令有误~~");
                            }
                        }
                    } else {
                        System.out.println("您输入的指令有误~~");
                    }
                }
            }
        }
        System.out.println("没有人提交请假申请~~");
    }

    //以下为刷新IO流方法


    //覆盖数据并读取
    public static void updateIOsAndLog(){
        try {
            LockForThread.INSTANCE.getLock().lock();
            //清空数据并对象序列化
            try(
                    FileOutputStream fos = new FileOutputStream(filePath,false);
                    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))
            ) {
                oos.writeObject(workers);
                //刷新流
                oos.flush();
                fos.getFD().sync();
            }catch (Exception e){
                e.getStackTrace();
            }

            //刷新后重载数据到workers中
            try(
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))

            ) {
                workers = (LinkedHashSet<Worker>) ois.readObject();
            }catch (Exception e){
                e.getStackTrace();
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }

    //不覆盖数据并读取
    public static void flushIOAndLog(){
        try {
            LockForThread.INSTANCE.getLock().lock();
            File file = new File(filePath);
            //刷新后重载数据到workers中
            if (file.length() > 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
                    // 强制刷新 workers 数据
                    workers = (LinkedHashSet<Worker>) ois.readObject();
                } catch (Exception e) {
                    e.getStackTrace();
                    System.err.println("读取 workers 文件失败，请检查文件是否损坏");
                }
            } else {
                System.out.println("文件为空，无需刷新");
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }


    //刷新worker
    public static Worker refreshWorker(Worker oldWorker){
        for (Worker newWorker : workers) {
            if(Objects.equals(newWorker.getWorkCode(),oldWorker.getWorkCode()) && Objects.equals(newWorker.getPassword(),oldWorker.getPassword())){
                return newWorker;
            }
        }
        return null;
    }


}
