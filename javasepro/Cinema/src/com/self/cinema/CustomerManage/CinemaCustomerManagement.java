package com.self.cinema.CustomerManage;

import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.Hall.Hall;
import com.self.cinema.CinemaManage.LoadAndUpdateCinemaMessage;
import com.self.cinema.CinemaManage.ScreenDays.ScreenDay;
import com.self.cinema.CinemaManage.ScreenDays.ScreenTimes.ScreenTime;
import com.self.cinema.CustomerManage.ChatWithFriend.ClientForChat;
import com.self.cinema.CustomerManage.ChatWithFriend.ServerForChat;
import com.self.cinema.CustomerManage.Customer.Customer;
import com.self.cinema.CustomerManage.Feedbacks.Feedback;
import com.self.cinema.CustomerManage.ProxyForWorker.CinemaForCustomer;
import com.self.cinema.CustomerManage.ProxyForWorker.ProxyForCustomer;
import com.self.cinema.CustomerManage.Records.Record;
import com.self.cinema.CustomerManage.ShowInfoOnBrowser.ServerForBrowser;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.MyUtils;
import com.self.cinema.StartCustomer.StartCustomer;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CinemaCustomerManagement implements CinemaForCustomer {
    public static LinkedHashSet<Customer> customers = new LinkedHashSet<>();

    //customers.txt路径
    private static final String filePath = FilePath.CUSTOMER_PATH_TO_TXT.getPath();//这个地方可能有点问题，路劲
    //IO流引入workers集合数据
    static {
        if (new File(filePath).length() != 0) {
            try (
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))
            ) {
                customers = (LinkedHashSet<Customer>) ois.readObject();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        //更新cinema
        CinemaManagerManagement.flushCinema();
        flushIOAndLog();
    }


    @Override
    public void startSystemForCustomer(){
        Scanner sc = new Scanner(System.in);
        String command;//指令
        System.out.println("------------------------用户管理系统------------------------");
        while (true){
            System.out.println("1.登录");
            System.out.println("2.创建账户");
            System.out.println("3.退出");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    Customer customer = StartCustomer.proxyForCustomer.customerLogin();
                    if(customer != null){
                        StartCustomer.proxyForCustomer.successLogin(customer);
                    }
                    break;
                case "2":
                    StartCustomer.proxyForCustomer.createCustomer();
                    break;
                case "3":
                    System.out.println("已退出系统，欢迎下次再来~~");
                    ProxyForCustomer.LOGGER.info("用户退出系统");
                    try {
                        updateIOsAndLog();
//                        LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
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
    public void createCustomer(){
        String UUID;
        String name;
        String gender;
        String phone;
        String userName;
        String userNameConfirm;
        String password;
        String passwordConfirm;
        String ip;
        InetAddress ipAddress;
        double money = 0;
        Scanner sc = new Scanner(System.in);
        //输入姓名
        System.out.println("请输入用户姓名： exit退出");
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
        System.out.println("请输入用户性别： exit退出");
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
        System.out.println("请输入用户电话： exit退出");
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
        //输入账号
        while (true) {
            while (true) {
                boolean flag = true;
                System.out.println("请您输入账户账号： exit退出");
                userName = sc.nextLine();
                if (Objects.equals("exit",userName)){
                    return;
                }
                for (Customer customer : customers) {
                    if(Objects.equals(customer.getUserName(),userName)){
                        flag = false;
                        System.out.println("该账号已经有人使用了~~");
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(userName.matches("[a-zA-Z0-9]{4,16}")){
                System.out.println("请再次输入您的账户账号： exit退出");
                userNameConfirm = sc.nextLine();
                if(Objects.equals(userNameConfirm,userName)){
                    break;
                } else if (Objects.equals("exit",userNameConfirm)) {
                    return;
                }else {
                    System.out.println("您输入的两次账号不一致，请重新确认！");
                }
            } else if (Objects.equals("exit",userName)) {
                return;
            }else {
                System.out.println("请输入数字或字母！且长度位于4到16位之间");
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
        //生成唯一号
        UUID = MyUtils.randomUUID().toString();
        //IP地址
        while (true) {
            System.out.println("请输入ip地址：");
            ip = sc.nextLine();
            if(ip.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")){
                try {
                    ipAddress = InetAddress.getByName(ip);
                    break;
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println("输入正确的ip地址~~");
            }
        }
        Customer customer = new Customer(ipAddress,money,password,userName,phone,gender,name,UUID);
        customers.add(customer);
        System.out.println("创建账户成功~~");

    }


    @Override
    public Customer customerLogin(){
        String userName;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号: exit退出");
        userName = sc.nextLine();
        if(Objects.equals("exit", userName)){
            return null;
        }
        for (Customer customer : customers) {
            if(Objects.equals(userName, customer.getUserName())){
                while (true) {
                    System.out.println("请输入密码： exit退出");
                    password = sc.nextLine();
                    if(Objects.equals("exit", password)){
                        return null;
                    }
                    if(Objects.equals(password, customer.getPassword())){
                        System.out.println("登陆成功！");
                        return customer;
                    }else {
                        System.out.println("密码错误！");
                    }
                }
            }
        }
        System.out.println("未找到该账号~~");
        return null;

    }


    @Override
    public void successLogin(Customer customer){
        try {
//            customer.setIp(InetAddress.getLocalHost());实验性功能，无法开放
            updateIOsAndLog();
            customer = refreshCustomer(customer);
            assert customer != null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------用户" + customer.getName() + "您好,欢迎进入工作系统------------------------");
        Scanner sc = new Scanner(System.in);
        String command;//指令
        while (true){
            System.out.println("1.查看电影信息");//控制台查看与bs查看
            System.out.println("2.查看账户余额以及个人信息");
            System.out.println("3.余额充值");
            System.out.println("4.评论");
            System.out.println("5.添加好友");
            System.out.println("6.和好友聊天");
            System.out.println("7.查看买票记录");
            System.out.println("8.买票");
            System.out.println("9.退票");
            System.out.println("10.退出登录");
            System.out.println("请输入指令：");
            command = sc.next();
            switch (command){
                case "1":
                    StartCustomer.proxyForCustomer.showMovieInfo();
                    break;
                case "2":
                    StartCustomer.proxyForCustomer.showMoneyAndInfo(customer);
                    break;
                case "3":
                    StartCustomer.proxyForCustomer.addMoney(customer);
                    break;
                case "4":
                    StartCustomer.proxyForCustomer.toFeedback(customer);
                    break;
                case "5":
                    StartCustomer.proxyForCustomer.addFriend(customer);
                    break;
                case "6":
                    StartCustomer.proxyForCustomer.chatWithFriend(customer);
                    break;
                case "7":
                    StartCustomer.proxyForCustomer.printRecord(customer);
                    break;
                case "8":
                    StartCustomer.proxyForCustomer.buyTicket(customer);
                    break;
                case "9":
                    StartCustomer.proxyForCustomer.returnTicket(customer);
                    break;
                case "10":
                    System.out.println("已退出登录，欢迎下次在来~~");
                    ProxyForCustomer.LOGGER.info("{}退出登录", customer.getName());
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }
    @Override
    public void showMovieInfo(){
        var ref = new Object() {
            ArrayList<String> movieNames = new ArrayList<>();
        };
        Scanner sc = new Scanner(System.in);
        String command;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("0.返回上一级");
        System.out.println("1.查看电影信息(控制台)");
        System.out.println("2.查看电影信息(浏览器)");
        System.out.println("请输入指令：");
        while (true){
            command = sc.nextLine();
            if(Objects.equals(command,"0")){
                return;
            } else if (Objects.equals(command,"1")) {
                for (Hall hall : CinemaManagerManagement.cinema) {
                    for (ScreenDay screenDay : hall.getScreenDays()) {
                        for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                            ref.movieNames.add(screenTime.getMovieName());
                        }
                    }
                }
                ref.movieNames = ref.movieNames.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
                System.out.println("-------------------------电影列表-------------------------");
                while (true) {
                    OUT:
                    for (String movieName : ref.movieNames) {
                        for (Hall hall : CinemaManagerManagement.cinema) {
                            for (ScreenDay screenDay : hall.getScreenDays()) {
                                for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                    if(Objects.equals(movieName,screenTime.getMovieName())){
                                        System.out.println(
                                                "电影名=" + screenTime.getMovieName() + '\n' +
                                                        "电影类型=" + screenTime.getMovieType() + '\n' +
                                                        "导演=" + screenTime.getDirector() + '\n' +
                                                        "演员=" + screenTime.getActors() + '\n' +
                                                        "时长=" + screenTime.getLastTime() + '\n' +
                                                        "评分=" + screenTime.getRate()
                                        );
                                        flushIOAndLog();//更新集合
                                        System.out.println("评论：");
                                        for (Customer customer : customers) {
                                            if(!customer.getComment().isEmpty()){
                                                customer.getComment().forEach((k,v) -> {
                                                    if(k.contains(screenTime.getMovieName())){
                                                        System.out.println(customer.getName() + ":");
                                                        System.out.println(v.getContent());
                                                        System.out.println("时间:" + formatter.format(v.getTime()));
                                                        System.out.println("IP地址:" + customer.getIp());
                                                    }
                                                });
                                            }
                                        }
                                        System.out.println(" ");
                                        ref.movieNames.remove(movieName);
                                        break OUT;
                                    }
                                }
                            }
                        }
                    }
                    if(ref.movieNames.isEmpty()){
                        return;
                    }
                }
            } else if (Objects.equals(command,"2")) {
                ServerForBrowser.startServerForBrowser();
                return;
            }else {
                System.out.println("输入指令有误~~");
            }
        }
    }

    @Override
    public void showMoneyAndInfo(Customer customer){
        //在开头的refresh不在需要flush，因为在代理中已经做过了
        customer = refreshCustomer(customer);
        assert customer != null;//断言
        System.out.println("您的ID:" + customer.getUUID());
        System.out.println("您的名字:" + customer.getName());
        System.out.println("您的性别:" + customer.getGender());
        System.out.println("您的电话:" + customer.getPhone());
        System.out.println("您的余额:" + customer.getMoney());
        System.out.println("您的IP地址:" + customer.getIp());
        System.out.println(" ");
    }

    @Override
    public void addMoney(Customer customer){
        try {
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            customer = refreshCustomer(customer);
            assert customer != null;//断言
            double money;
            System.out.println("请输入您要充值的金额： 0返回上一级");
            while (true) {
                try {
                    money = MyUtils.doubleInput();
                    break;
                } catch (Exception e) {
                    System.out.println("请输入纯数字,重新输入:");
                }
            }
            if(money == 0){
                return;
            }
            customer.getLock().lock();
            customer.setMoney(customer.getMoney() + money);
            System.out.println("充值成功~~");
        } finally {
            assert customer != null;
            if(customer.getLock().tryLock()){
                customer.getLock().unlock();
            }
        }
    }

    @Override
    public void toFeedback(Customer customer){
        try {
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            customer = refreshCustomer(customer);
            assert customer != null;//断言
            Scanner sc = new Scanner(System.in);
            int command;
            String content;
            var ref = new Object() {
                ArrayList<String> movieNames = new ArrayList<>();
                int sum;//用户在某部电影的评论总数
            };
            for (Hall hall : CinemaManagerManagement.cinema) {
                for (ScreenDay screenDay : hall.getScreenDays()) {
                    for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                        ref.movieNames.add(screenTime.getMovieName());
                    }
                }
            }
            ref.movieNames = ref.movieNames.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
            while (true) {
                System.out.println("0.返回上一级");
                for (int i = 0; i < ref.movieNames.size(); i++) {
                    System.out.println((i+1) + "." + ref.movieNames.get(i));
                }
                System.out.println("请输入指令：");
                while (true) {
                    try {
                        command = MyUtils.intInput();
                        break;
                    }catch (Exception e){
                        System.out.println("请输入纯数字~~");
                    }
                }
                if(command == 0){
                    return;
                } else if (command > 0 && command <= ref.movieNames.size()) {
                    System.out.println("请输入评论内容~~  exit退出");
                    content = sc.nextLine();
                    if(content.matches("(?i)\\b(?:([肏草操]你?[妈妹姐]|傻[\\s\\W]*?逼|蠢[\\s\\W]*?货|你?个?[傻煞][逼比毕]|f[\\s\\W]*?uck|b[\\s\\W]*?itch|shit|admin|习近平|共产党)|([他她它]妈|狗[\\s\\W]*?日的?|操|滚蛋)|(\\bass(hole)?\\b|dick|cock))\\b\n|wdf")){
                        System.out.println("您输入的内容过于敏感或非文明，不适合发布~~");
                    } else if (Objects.equals(content,"exit")) {
                        return;
                    } else {
                        Feedback feedback = new Feedback(content, LocalDateTime.now());
                        customer.getComment().forEach((k,v) -> {
                            for (String movieName : ref.movieNames) {
                                if(k.contains(movieName)){
                                    ref.sum++;
                                }
                            }
                        });
                        customer.getLock().lock();
                        customer.getComment().put(ref.movieNames.get(command - 1) + ref.sum,feedback);
                        System.out.println("评论成功~~");
                        return;
                    }
                } else {
                    System.out.println("输入指令有误~~");
                }
            }
        } finally {
            assert customer != null;
            if(customer.getLock().tryLock()){
                customer.getLock().unlock();
            }
        }
    }

    @Override
    public void addFriend(Customer customer){
        try {
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            customer = refreshCustomer(customer);
            assert customer != null;//断言
            Scanner sc = new Scanner(System.in);
            String UUID;
            while (true){
                boolean flag = true;
                System.out.println("请输入您要添加好友的ID: exit退出");
                UUID = sc.nextLine();
                if (!customer.getFriends().isEmpty()) {
                    for (String friend : customer.getFriends()) {
                        if(Objects.equals(friend,UUID)){
                            System.out.println("您已添加该好友~~");
                            return;
                        }
                    }
                }
                if(Objects.equals(UUID,customer.getUUID())){
                    System.out.println("您不能添加自己为好友~~");
                    return;
                } else if (Objects.equals(UUID,"exit")) {
                    return;
                } else if (UUID.matches("\\d{8}")){
                    for (Customer Friend : customers) {
                        if(Objects.equals(Friend.getUUID(),UUID)){
                            customer.getLock().lock();
                            customer.getFriends().add(Friend.getUUID());
                            Friend.getFriends().add(customer.getUUID());
                            System.out.println("好友添加成功~~");
                            return;
                        }
                    }
                } else {
                    flag = false;
                    System.out.println("请输入正确的ID~~");
                }
                if (flag) {
                    System.out.println("未找到该用户~~");
                }
            }
        } finally {
            assert customer != null;
            if(customer.getLock().tryLock()){
                customer.getLock().unlock();
            }
        }
    }

    @Override
    public void chatWithFriend(Customer customer){
        //在开头的refresh不在需要flush，因为在代理中已经做过了
        customer = refreshCustomer(customer);
        assert customer != null;//断言
        var ref = new Object() {
            int i = 0;
        };
        int command;
        InetAddress friendIp;
        if(customer.getFriends().isEmpty()){
            System.out.println("您还没有好友,请前往添加~~");
            return;
        }
        while (true) {
            System.out.println("0.返回上一级");
            customer.getFriends().forEach(ele -> {
                for (Customer Friend : customers) {
                    if(Objects.equals(Friend.getUUID(),ele)){
                        ref.i++;
                        System.out.println(ref.i + "." + Friend.getName());
                    }
                }
            });
            while (true){
                try {
                    command = MyUtils.intInput();
                    break;
                }catch (Exception e){
                    System.out.println("请输入纯数字~~");
                }
            }
            flushIOAndLog();
            if(Objects.equals(command,0)){
                return;
            } else if (command > 0 && command <= ref.i) {
                for (Customer Friend : customers) {
                    if(Objects.equals(Friend.getUUID(),customer.getFriends().stream().skip(command - 1).limit(1).findFirst().get())){
                        friendIp = Friend.getIp();//由于数据都在我的电脑上，所以所有账号的ip地址都是我的电脑的ip地址，若要使用该功能需要创建指定ip地址的用户
                        System.out.println(friendIp);
                        ServerForChat.startServer();
                        ClientForChat.startClient(friendIp);
                        return;
                    }
                }
            } else {
                System.out.println("您输入的指令有误~~");
            }
        }

    }

    @Override
    public void buyTicket(Customer customer){
        try {
            LocalDate date;//日期
            LocalTime startTime;//开始时间
            LocalTime endTime;//结束时间
            String place;//哪个厅
            String movieName;//影片名称
            String movieType;//影片类型
            String dimension;//影片尺寸
            String director;//导演
            String actors;//演员
            String language;//语言
            int lastTime;//片长
            double price;//票价
            double rate;//评分
            boolean isCancel;//是否退票

            int command1;//第一层指令
            int command2;//第二层指令
            int command3;//第三层指令
            int command4;//第四层指令
            int command5;//第五层指令

            //在开头的refresh不在需要flush，因为在代理中已经做过了
            customer = refreshCustomer(customer);
            assert customer != null;//断言
            while (true){
                var ref = new Object() {
                    ArrayList<String> movieNames = new ArrayList<>();
                    ArrayList<LocalDate> movieDays = new ArrayList<>();
                    LinkedHashMap<ScreenTime,String> movies = new LinkedHashMap<>();
                    int index;
                };
                for (Hall hall : CinemaManagerManagement.cinema) {
                    for (ScreenDay screenDay : hall.getScreenDays()) {
                        for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                            ref.movieNames.add(screenTime.getMovieName());
                        }
                    }
                }
                //去重
                ref.movieNames = ref.movieNames.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
                System.out.println("0.返回上一级");
                for (int i = 0; i < ref.movieNames.size(); i++) {
                    System.out.println((i+1) + "." + ref.movieNames.get(i));
                }
                System.out.println("请输入指令：");
                while (true) {
                    try {
                        command1 = MyUtils.intInput();
                        break;
                    } catch (Exception e) {
                        System.out.println("请输入纯数字~~");
                    }
                }
                if(Objects.equals(command1,0)){
                    return;
                } else if (command1 > 0 && command1 <= ref.movieNames.size()) {
                    movieName = ref.movieNames.get(command1 - 1);
                    for (Hall hall : CinemaManagerManagement.cinema) {
                        for (ScreenDay screenDay : hall.getScreenDays()) {
                            ref.movieDays.add(screenDay.getDateInfo());
                        }
                    }
                    //去重 过滤超过今天的 排序
                    ref.movieDays = ref.movieDays.stream().distinct().sorted(Comparator.comparing(LocalDate::getDayOfYear)).filter(dateInfo -> dateInfo.isAfter(LocalDate.now()) || dateInfo.equals(LocalDate.now())).collect(Collectors.toCollection(ArrayList::new));
                    while (true) {
                        System.out.println("0.返回上一级");
                        for (int i = 0; i < ref.movieDays.size(); i++) {
                            System.out.println((i + 1) + "." + ref.movieDays.get(i));
                        }
                        System.out.println("请输入指令：");
                        while (true) {
                            try {
                                command2 = MyUtils.intInput();
                                break;
                            } catch (Exception e) {
                                System.out.println("请输入纯数字~~");
                            }
                        }
                        if(Objects.equals(command2,0)){
                            break;
                        } else if (command2 > 0 && command2 <= ref.movieDays.size()) {
                            date = ref.movieDays.get(command2 - 1);
                            for (Hall hall : CinemaManagerManagement.cinema) {
                                for (ScreenDay screenDay : hall.getScreenDays()) {
                                    for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                        if(Objects.equals(screenTime.getMovieName(),movieName) && Objects.equals(screenDay.getDateInfo(),date)){
                                            ref.movies.put(screenTime,hall.getHallName());
                                        }
                                    }
                                }
                            }
                            //去重 排序
                            if(date.isEqual(LocalDate.now())){
                                ref.movies = ref.movies.entrySet().stream().sorted(Comparator.comparing(o -> o.getKey().getStartTime())).filter(o -> o.getKey().getStartTime().isAfter(LocalTime.now())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                            } else if (date.isAfter(LocalDate.now())) {
                                ref.movies = ref.movies.entrySet().stream().sorted(Comparator.comparing(o -> o.getKey().getStartTime())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                            }
                            while (true){
                                ref.index = 0;
                                System.out.println("0.返回上一级");
                                ref.movies.forEach((k,v) -> {
                                    ref.index++;
                                    System.out.println(ref.index + "." + v + ":" + k.getStartTime() + "——" + k.getEndTime() + ":￥" + k.getPrice());
                                });
                                System.out.println("请输入指令：");
                                while (true) {
                                    try {
                                        command3 = MyUtils.intInput();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("请输入纯数字~~");
                                    }
                                }
                                if(Objects.equals(command3,0)){
                                    break;
                                } else if (command3 > 0 && command3 <= ref.index) {
                                    startTime = ref.movies.keySet().stream().toList().get(command3 - 1).getStartTime();
                                    endTime = ref.movies.keySet().stream().toList().get(command3 - 1).getEndTime();
                                    place = ref.movies.entrySet().stream().toList().get(command3 - 1).getValue();
                                    movieType = ref.movies.keySet().stream().toList().get(command3 - 1).getMovieType();
                                    dimension = ref.movies.keySet().stream().toList().get(command3 - 1).getDimension();
                                    director = ref.movies.keySet().stream().toList().get(command3 - 1).getDirector();
                                    actors = ref.movies.keySet().stream().toList().get(command3 - 1).getActors();
                                    language = ref.movies.keySet().stream().toList().get(command3 - 1).getLanguage();
                                    lastTime = ref.movies.keySet().stream().toList().get(command3 - 1).getLastTime();
                                    price = ref.movies.keySet().stream().toList().get(command3 - 1).getPrice();
                                    rate = ref.movies.keySet().stream().toList().get(command3 - 1).getRate();
                                    isCancel = false;
                                    ref.movies.keySet().stream().toList().get(command3 - 1).printSeats();
                                    while (true){
                                        System.out.println("请输入座位号：  0返回上一级");
                                        while (true) {
                                            try {
                                                command4 = MyUtils.intInput();
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("请输入纯数字~~");
                                            }
                                        }
                                        if(Objects.equals(command4,0)){
                                            break;
                                        } else if (command4 > 0 && command4 <= ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().size() && ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().get(command4 - 1) == null) {
                                            if(customer.getMoney() < ref.movies.keySet().stream().toList().get(command3 - 1).getPrice()){
                                                System.out.println("您的余额不足，请前往充值~~");
                                                return;
                                            }else {
                                                while (true) {
                                                    System.out.println("小吃:");
                                                    System.out.println("0.什么都不买");
                                                    System.out.println("1.46oz爆米花1桶+16oz可乐       ￥30");
                                                    System.out.println("2.64oz爆米花1桶+16oz可乐两杯    ￥50");
                                                    System.out.println("3.85oz爆米花1桶+22oz可乐三杯    ￥60");
                                                    System.out.println("请输入指令：");
                                                    while (true) {
                                                        try {
                                                            command5 = MyUtils.intInput();
                                                            break;
                                                        } catch (Exception e) {
                                                            System.out.println("请输入纯数字~~");
                                                        }
                                                    }
                                                    if(command5 == 0){
                                                        customer.getLock().lock();
                                                        if (customer.getMoney() >= price + 0) {
                                                            Record record = new Record(date,startTime,endTime,place,movieName,movieType,dimension,director,actors,language,lastTime,price,rate,"无",command4,isCancel);
                                                            customer.getRecords().add(record);
                                                            customer.setMoney(customer.getMoney() - price);
                                                            ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().put(command4 - 1, customer);
                                                            LoadAndUpdateCinemaMessage.updateSeatInfo(place,date,startTime,command4,customer,false);//更新Cinema.xml
                                                            OUT:
                                                            for (Hall hall : CinemaManagerManagement.cinema) {
                                                                if(Objects.equals(hall.getHallName(),place)){
                                                                    for (ScreenDay screenDay : hall.getScreenDays()) {
                                                                        if(Objects.equals(screenDay.getDateInfo(),date)){
                                                                            for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                                                if(Objects.equals(screenTime.getStartTime(),startTime)){
                                                                                    screenTime.getSeats().put(command4 - 1, customer);
                                                                                    break OUT;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            System.out.println("买票成功，记得来看~~");
                                                        }else {
                                                            System.out.println("余额不足~~");
                                                        }
                                                        return;
                                                    } else if (command5 == 1) {
                                                        customer.getLock().lock();
                                                        if(customer.getMoney() >= price + 30){
                                                            Record record = new Record(date,startTime,endTime,place,movieName,movieType,dimension,director,actors,language,lastTime,price,rate,"46oz爆米花1桶+16oz可乐 30元",command4,isCancel);
                                                            customer.getRecords().add(record);
                                                            customer.setMoney(customer.getMoney() - price - 30);
                                                            ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().put(command4 - 1, customer);
                                                            LoadAndUpdateCinemaMessage.updateSeatInfo(place,date,startTime,command4,customer,false);//更新Cinema.xml
                                                            OUT:
                                                            for (Hall hall : CinemaManagerManagement.cinema) {
                                                                if(Objects.equals(hall.getHallName(),place)){
                                                                    for (ScreenDay screenDay : hall.getScreenDays()) {
                                                                        if(Objects.equals(screenDay.getDateInfo(),date)){
                                                                            for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                                                if(Objects.equals(screenTime.getStartTime(),startTime)){
                                                                                    screenTime.getSeats().put(command4 - 1, customer);
                                                                                    break OUT;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            System.out.println("买票成功，记得来看~~");
                                                        }else {
                                                            System.out.println("余额不足~~");
                                                        }
                                                        return;
                                                    } else if (command5 == 2) {
                                                        customer.getLock().lock();
                                                        if(customer.getMoney() >= price + 50){
                                                            Record record = new Record(date,startTime,endTime,place,movieName,movieType,dimension,director,actors,language,lastTime,price,rate,"64oz爆米花1桶+16oz可乐两杯 50元",command4,isCancel);
                                                            customer.getRecords().add(record);
                                                            customer.setMoney(customer.getMoney() - price - 50);
                                                            ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().put(command4 - 1, customer);
                                                            LoadAndUpdateCinemaMessage.updateSeatInfo(place,date,startTime,command4,customer,false);//更新Cinema.xml
                                                            OUT:
                                                            for (Hall hall : CinemaManagerManagement.cinema) {
                                                                if(Objects.equals(hall.getHallName(),place)){
                                                                    for (ScreenDay screenDay : hall.getScreenDays()) {
                                                                        if(Objects.equals(screenDay.getDateInfo(),date)){
                                                                            for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                                                if(Objects.equals(screenTime.getStartTime(),startTime)){
                                                                                    screenTime.getSeats().put(command4 - 1, customer);
                                                                                    break OUT;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            System.out.println("买票成功，记得来看~~");
                                                        }else {
                                                            System.out.println("余额不足~~");
                                                        }
                                                        return;
                                                    } else if (command5 == 3) {
                                                        customer.getLock().lock();
                                                        if(customer.getMoney() >= price + 60){
                                                            Record record = new Record(date,startTime,endTime,place,movieName,movieType,dimension,director,actors,language,lastTime,price,rate,"85oz爆米花1桶+22oz可乐三杯 60元",command4,isCancel);
                                                            customer.getRecords().add(record);
                                                            customer.setMoney(customer.getMoney() - price - 60);
                                                            ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().put(command4 - 1, customer);
                                                            LoadAndUpdateCinemaMessage.updateSeatInfo(place,date,startTime,command4,customer,false);//更新Cinema.xml
                                                            OUT:
                                                            for (Hall hall : CinemaManagerManagement.cinema) {
                                                                if(Objects.equals(hall.getHallName(),place)){
                                                                    for (ScreenDay screenDay : hall.getScreenDays()) {
                                                                        if(Objects.equals(screenDay.getDateInfo(),date)){
                                                                            for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                                                if(Objects.equals(screenTime.getStartTime(),startTime)){
                                                                                    screenTime.getSeats().put(command4 - 1, customer);
                                                                                    break OUT;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            System.out.println("买票成功，记得来看~~");
                                                        }else {
                                                            System.out.println("余额不足~~");
                                                        }
                                                        return;
                                                    } else {
                                                        System.out.println("您输入的指令有误~~");
                                                    }
                                                }
                                            }
                                        } else if (command4 > 0 && command4 <= ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().size() && ref.movies.keySet().stream().toList().get(command3 - 1).getSeats().get(command4 - 1) != null) {
                                            System.out.println("该座位已经有人坐了~~");
                                        } else {
                                            System.out.println("您输入的指令有误~~");
                                        }
                                    }
                                }else {
                                    System.out.println("您输入的指令有误~~");
                                }
                            }
                        } else {
                            System.out.println("您输入的指令有误~~");
                        }
                    }
                } else {
                    System.out.println("您输入的指令有误~~");
                }
            }
        } finally {
            assert customer != null;
            if(customer.getLock().tryLock()){
                customer.getLock().unlock();
            }
        }
    }

    @Override
    public void printRecord(Customer customer) {
        //在开头的refresh不在需要flush，因为在代理中已经做过了
        customer = refreshCustomer(customer);
        assert customer != null;
        if(customer.getRecords().isEmpty()){
            System.out.println("您还没有购买记录~~");
            return;
        }
        for (Record record : customer.getRecords()) {
            record.printInfo();
        }
    }

    @Override
    public void returnTicket(Customer customer) {
        try {
            Scanner sc = new Scanner(System.in);
            int index = 0;
            int command;
            String confirm;
            //在开头的refresh不在需要flush，因为在代理中已经做过了
            customer = refreshCustomer(customer);
            assert customer != null;
            if(customer.getRecords().isEmpty()){
                System.out.println("您还没有购买记录~~");
                return;
            }
            System.out.println("0.返回上一级");
            for (Record record : customer.getRecords()) {
                index++;
                System.out.println(index + ":");
                record.printInfo();
            }
            System.out.println("请输入指令：");
            while (true){
                while (true){
                    try {
                        command = MyUtils.intInput();
                        break;
                    } catch (Exception e) {
                        System.out.println("请输入纯数字~~");
                    }
                }
                if(Objects.equals(command,0)){
                    return;
                } else if (command > 0 && command <= customer.getRecords().size()) {
                     if (customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().isCancel()) {
                        System.out.println("该电影已退款，无法重复操作~~");
                        return;
                    }else if(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate().isBefore(LocalDate.now())){
                        System.out.println("电影已经放映完毕，无法退款~~");
                        return;
                    } else if (customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate().isAfter(LocalDate.now())) {
                        System.out.println("您确定要退款吗？  y/n");
                        while (true){
                            confirm = sc.nextLine();
                            if(Objects.equals(confirm, "y")){
                                customer.getLock().lock();
                                if (!customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().isCancel()) {
                                    customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().setCancel(true);//退票标记
                                    customer.setMoney(customer.getMoney() + customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPrice() + Integer.parseInt(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().substring(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().length()-3,customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().length()-1)));//退款
                                    LoadAndUpdateCinemaMessage.updateSeatInfo(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPlace(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getSeatNumber(),customer,true);//更新Cinema.xml
                                    OUT:
                                    for (Hall hall : CinemaManagerManagement.cinema) {
                                        if(Objects.equals(hall.getHallName(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPlace())){
                                            for (ScreenDay screenDay : hall.getScreenDays()) {
                                                if(Objects.equals(screenDay.getDateInfo(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate())){
                                                    for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                        if(Objects.equals(screenTime.getStartTime(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime())){
                                                            screenTime.getSeats().put(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getSeatNumber() - 1, null);
                                                            break OUT;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("已退款~~");
                                }else {
                                    System.out.println("该场次已退票~~");
                                }
                                return;
                            } else if (Objects.equals(confirm,"n")) {
                                System.out.println("已保留~~");
                                return;
                            } else {
                                System.out.println("输入有误，请重新输入:");
                            }
                        }
                    } else if (customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate().isEqual(LocalDate.now())) {
                        if(LocalTime.now().isBefore(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime().minusHours(1))){
                            System.out.println("您确定要退款吗？  y/n");
                            while (true){
                                confirm = sc.nextLine();
                                if(Objects.equals(confirm, "y")){
                                    customer.getLock().lock();
                                    if (!customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().isCancel()) {
                                        customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().setCancel(true);//退票标记
                                        customer.setMoney(customer.getMoney() + customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPrice() + Integer.parseInt(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().substring(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().length()-3,customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getOthers().length()-1)));//退款
                                        LoadAndUpdateCinemaMessage.updateSeatInfo(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPlace(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getSeatNumber(),customer,true);//更新Cinema.xml
                                        OUT:
                                        for (Hall hall : CinemaManagerManagement.cinema) {
                                            if(Objects.equals(hall.getHallName(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getPlace())){
                                                for (ScreenDay screenDay : hall.getScreenDays()) {
                                                    if(Objects.equals(screenDay.getDateInfo(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getDate())){
                                                        for (ScreenTime screenTime : screenDay.getScreenTimes()) {
                                                            if(Objects.equals(screenTime.getStartTime(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime())){
                                                                screenTime.getSeats().put(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getSeatNumber() - 1, null);
                                                                break OUT;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println("已退款~~");
                                    } else {
                                        System.out.println("该场次已退票~~");
                                    }
                                    return;
                                } else if (Objects.equals(confirm,"n")) {
                                    System.out.println("已保留~~");
                                    return;
                                } else {
                                    System.out.println("输入有误，请重新输入:");
                                }
                            }
                        } else if ((LocalTime.now().isAfter(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime().minusHours(1)) && LocalTime.now().isBefore(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime())) || Objects.equals(LocalTime.now(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime().minusHours(1))) {
                            System.out.println("距离开场还有一个小时，已无法退款~~");
                            return;
                        } else if (Objects.equals(LocalTime.now(),customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime()) || LocalTime.now().isAfter(customer.getRecords().stream().skip(command - 1).limit(1).findFirst().get().getStartTime())) {
                            System.out.println("电影已开场，已无法退款~~");
                            return;
                        }
                    }
                } else {
                    System.out.println("您输入的指令有误~~");
                }
            }
        } finally {
            assert customer != null;
            if(customer.getLock().tryLock()){
                customer.getLock().unlock();
            }
        }
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
                oos.writeObject(customers);
                //刷新流
                oos.flush();
                fos.getFD().sync();
            }catch (Exception e){
                e.getStackTrace();
            }

            //刷新后重载数据到customers中
            try(
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))

            ) {
                customers = (LinkedHashSet<Customer>) ois.readObject();
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
            //刷新后重载数据到customers中
            if (file.length() > 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
                    // 强制刷新 customers 数据
                    customers = (LinkedHashSet<Customer>) ois.readObject();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }


    //刷新customer
    public static Customer refreshCustomer(Customer oldCustomer){
        for (Customer newCustomer : customers) {
            if(Objects.equals(newCustomer.getUUID(), oldCustomer.getUUID())){
                return newCustomer;
            }
        }
        return null;
    }
}
