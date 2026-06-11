package newATM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.System;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {

    public static final Logger LOGGER = LoggerFactory.getLogger("LogTracer");
    private ArrayList<Account> accounts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    //对象序列化的对象创建
    public static ObjectOutputStream oos;
    //对象反序列化对象创建
    public static ObjectInputStream ois = null;



    public ATM(){
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt",true)));
            LOGGER.info("追加对象输出流创建成功，继承上次运行数据");
            if (new File("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt").length() != 0) {
                ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt")));
                accounts = (ArrayList<Account>) ois.readObject();
                LOGGER.info("对象输入流创建成功，并接通accounts集合，已读取数据");
            }
        } catch (Exception e) {
            LOGGER.error("对象输入流创建失败");
            stopOOS();
            stopOIS();
            throw new RuntimeException(e);
        }
    }


    public void start() throws Exception{
        Scanner sc = new Scanner(System.in);
        while (true) {
            //开户有线程安全的问题
            LOGGER.info("已进入系统");
            System.out.println("欢迎登录ATM银行系统==========================================");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("3.退出系统");
            System.out.print("请选择你要操作的命令：");
            switch (sc.next()){
                case "1" :
                    if(accounts.isEmpty()){
                        System.out.println("您好，当前系统无账户~~");
                        break;
                    }
                    LOGGER.info("匿名用户选择了登录");
                    works(loginIn());
                    break;
                case "2" :
                    LOGGER.info("匿名用户创建账号");
                    creatAccount();
                    break;
                case "3" :
                    System.out.println("已退出系统，欢迎下次再来~~");
                    //清空数据并对象序列化
                    stopOOS();
                    oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt",false)));
                    oos.writeObject(accounts);
                    stopOOS();
                    stopOIS();
                    //根据txt二进制文件转换为注册日志
                    TranslateToRegisterLog.registerLog();
                    LOGGER.info("该用户退出了系统系统，并更新了二进制日志与注册表日志");
                    return;
                default:
                    LOGGER.warn("用户输入的指令有误");
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    public void creatAccount() throws Exception{
        Account account = new Account();
        LOGGER.info("account已创建，但仍未被赋值");
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入账户的用户名：");
        while (true) {
            String name = sc.next();
            if (name.matches("^[\\u4e00-\\u9fa5A-Za-z ]+$")){
                account.setUserName(name);
                break;
            }else {
                LOGGER.warn("姓名输入错误");
                System.out.println("用户名必须是英文或字母的组合，请重新输入：");
            }
        }
        LOGGER.info("成功录入姓名");
        System.out.println("请输入您的性别：");
        while (true) {
            String sex = sc.next();
            if(Objects.equals("男",sex) || Objects.equals("女",sex)){
                account.setSex(sex.charAt(0));
                break;
            }else {
                LOGGER.warn("性别输入有误");
                System.out.println("您输入的性别有误，请重新输入：");
            }
        }
        LOGGER.info("成功录入性别");
        while (true) {
            System.out.println("请您输入账户密码：");
            String password = sc.next();
            if(password.matches("[0-9a-zA-Z]{5,20}")){
                System.out.println("请再次输入您的账户密码：");
                String passwordText = sc.next();
                if(Objects.equals(passwordText,password)){
                    account.setPassword(password);
                    break;
                }else {
                    LOGGER.warn("两次密码输入不一致");
                    System.out.println("您输入的两次密码不一致，请重新确认！");
                }
            }else {
                LOGGER.warn("密码输入有误");
                System.out.println("请输入数字或字母！且长度位于5到20位之间");
            }
        }
        LOGGER.info("成功录入密码");
        while (true){
            try {
                account = QuotaMoneyInput(account);
                break;
            }catch (Exception e){
                LOGGER.warn("限额输入有误");
                System.out.println("请输入纯数字作为限额");
            }
        }
        LOGGER.info("成功录入限额");
        StringBuilder id = randomCardId();
        account.setCardId(id.toString());
        LOGGER.info("成功生成id");
        account.setTime(LocalDateTime.now());
        LOGGER.info("成功录入时间");
        accounts.add(account);
        updateLogs();
        if(Objects.equals(account.getSex(),'男')) {
            System.out.println("恭喜您," + account.getUserName().charAt(0) + "先生,您开户成功," + "您的卡号是" + account.getCardId() + ",请妥善保管您的卡号");
        }
        if(Objects.equals(account.getSex(),'女')){
            System.out.println("恭喜您," + account.getUserName().charAt(0) + "女士,您开户成功," + "您的卡号是" + account.getCardId() + ",请妥善保管您的卡号");
        }
        LOGGER.info("注册成功,account已添加至accounts集合,并刷新了二进制日志和注册表日志");
    }

    public Account QuotaMoneyInput(Account account){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账户每次取现限额：");
        account.setQuotaMoney(sc.nextDouble());
        return account;
    }
    public int loginIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================系统登录操作==================================");
        System.out.println("请输入您登录的卡号：");
        String idIndex;
        OUT:
        while (true){
            String id = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(id,accounts.get(i).getCardId())){
                   idIndex = id;
                   break OUT;
                } else if (i == accounts.size()-1) {
                    System.out.println("系统中不存在该账户卡号,请重新输入：");
                    LOGGER.warn("输入错误");
                    break;
                }
            }
        }
        LOGGER.info("成功输入卡号");

        int codeRemember;
        System.out.println("请输入您的登录密码：");
        OUT:
        while (true){
            String password = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(password,accounts.get(i).getPassword()) && Objects.equals(idIndex,accounts.get(i).getCardId())){
                    if(Objects.equals(accounts.get(i).getSex(),'男')) {
                        System.out.println("恭喜您" + accounts.get(i).getUserName().charAt(0) + "先生，您已进入系统，您的卡号是：" + accounts.get(i).getCardId());
                        codeRemember = i;
                        break OUT;
                    }
                    if(Objects.equals(accounts.get(i).getSex(),'女')) {
                        System.out.println("恭喜您" + accounts.get(i).getUserName().charAt(0) + "女士，您已进入系统，您的卡号是：" + accounts.get(i).getCardId());
                        codeRemember = i;
                        break OUT;
                    }
                }else if(i == accounts.size()-1){
                    LOGGER.warn("密码输入错误");
                    System.out.println("您输入的密码有误，请重新输入：");
                    break;
                }
            }
        }
        LOGGER.info("{}成功登录", accounts.get(codeRemember).getUserName());
        return codeRemember;
    }

    public void works(int code) throws Exception{
        Scanner sc = new Scanner(System.in);
        while (true){
            if(Objects.equals(accounts.get(code).getSex(),'男')) {
                System.out.println("====================" + accounts.get(code).getUserName() + "先生，您可以办理以下业务=====================");
            }
            if(Objects.equals(accounts.get(code).getSex(),'女')) {
                System.out.println("====================" + accounts.get(code).getUserName() + "女士，您可以办理以下业务=====================");
            }
            //存款，取款，转账，注销账户和改密码有线程安全问题
        System.out.println("1.查询账户");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.转账");
        System.out.println("5.修改密码");
        System.out.println("6.退出登录");
        System.out.println("7.注销账户");
        System.out.print("请选择：");
        switch (sc.next()) {
            case "1":
                LOGGER.info("{}查询账户", accounts.get(code).getUserName());
                visitAccount(code);
                break;
            case "2":
                LOGGER.info("{}存款", accounts.get(code).getUserName());
                saveAccount(code);
                break;
            case "3":
                LOGGER.info("{}取款", accounts.get(code).getUserName());
                takeAccount(code);
                break;
            case "4":
                LOGGER.info("{}转账", accounts.get(code).getUserName());
                sendMoney(code);
                break;
            case "5":
                LOGGER.info("{}修改密码", accounts.get(code).getUserName());
                changAccount(code);
                return;
            case "6":
                LOGGER.info("{}退出登录", accounts.get(code).getUserName());
                System.out.println("您已成功退出登录，欢迎下次再来~~");
                return;
            case "7":
                LOGGER.info("{}注销账户", accounts.get(code).getUserName());
                deleteAccount(code);
                return;
            default:
                LOGGER.warn("输入指令有误");
                System.out.println("请输入正确的指令~~");
                break;
        }
        }
    }

    public void visitAccount(int code){
        System.out.println("=====================当前账户信息如下======================");
        System.out.println("卡号：" + accounts.get(code).getCardId());
        System.out.println("户主：" + accounts.get(code).getUserName());
        System.out.println("性别：" + accounts.get(code).getSex());
        System.out.println("余额：" + accounts.get(code).getMoney());
        System.out.println("限额：" + accounts.get(code).getQuotaMoney());
        System.out.println("建卡时间：" + accounts.get(code).getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        LOGGER.info("{}成功查询账户", accounts.get(code).getUserName());
    }

    public void saveAccount(int code){
        System.out.println("==============================用户存钱操作=============================");
        while (true){
            try {
                saveAccountInput(code);
                break;
            } catch (Exception e) {
                LOGGER.error("输入错误");
                System.out.println("请输入正确的数字！");
            }
        }
        LOGGER.info("{}成功存钱", accounts.get(code).getUserName());
    }

    public void saveAccountInput(int code) throws Exception{
        if (!lock.tryLock()){
            LOGGER.error("该用户正在操作，已锁");
            System.out.println("该账户正在进行存款操作,请稍后~~");
            return;
        }
        lock.lock();
        LOGGER.info("已上锁");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的存款金额：");
        accounts.get(code).setMoney(accounts.get(code).getMoney() + sc.nextDouble());
        System.out.println("恭喜您存钱成功，当前账户信息如下");
        updateLogs();
        lock.unlock();
        visitAccount(code);
        LOGGER.info("{}成功存钱，并刷新了二进制日志与注册表日志，解锁，而且查看了修改后的信息", accounts.get(code).getUserName());
    }

    public void takeAccount(int code){
        System.out.println("==============================用户取钱操作=============================");
        if(accounts.get(code).getMoney() == 0){
            System.out.println("当前账户没钱，不能取款");
            LOGGER.warn("{}取款失败，当前账户没钱", accounts.get(code).getUserName());
            return;
        }
        while (true) {
            try {
                takeAccountInput(code);
                break;
            } catch (Exception e) {
                LOGGER.error("{}取款失败，请输入正确的数字", accounts.get(code).getUserName());
                System.out.println("请输入正确的数字！");
            }
        }
    }

    public void takeAccountInput(int code) throws Exception{
        if (!lock.tryLock()){
            LOGGER.error("该用户正在操作，已锁");
            System.out.println("该账户正在进行取款操作,请稍后~~");
            return;
        }
        lock.lock();
        LOGGER.info("已上锁");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的取款金额：");
        while (true) {
            double money = sc.nextDouble();
            if(money > accounts.get(code).getQuotaMoney()){
                LOGGER.warn("{}取款失败，超过限额", accounts.get(code).getUserName());
                System.out.println("您当前取款金额超过每次限额，每次最多可取" + accounts.get(code).getQuotaMoney() + "元,请重新输入：");
            }else if(accounts.get(code).getMoney() < money){
                LOGGER.warn("{}取款失败，余额不足", accounts.get(code).getUserName());
                System.out.println("余额不足，您的账户目前的总余额为" + accounts.get(code).getMoney() + "元,请再次输入您的取款余额：");
            }
            else {
                accounts.get(code).setMoney(accounts.get(code).getMoney() - money);
                System.out.println("恭喜您，取钱" + money + "元" + "，成功！");
                updateLogs();
                lock.unlock();
                visitAccount(code);
                LOGGER.info("{}成功取款，并刷新了二进制日志与注册表日志，解锁，而且查看了修改后的信息", accounts.get(code).getUserName());
                break;
            }
        }
    }

    public void sendMoney(int code){
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================用户转账操作=========================");
        if(accounts.size() < 2){
            LOGGER.warn("{}转账失败，当前系统中不足两个用户", accounts.get(code).getUserName());
            System.out.println("当前系统中不足两个用户，不能进行转账，请去开户吧~~");
            return;
        }
        if(accounts.get(code).getMoney() == 0){
            LOGGER.warn("{}转账失败，用户自己都没钱了", accounts.get(code).getUserName());
            System.out.println("您自己都没钱了，就别转了吧~~");
            return;
        }
        String opposite;
        OUT:
        while (true){
            System.out.println("请您输入对方卡号：");
            opposite = sc.next();
            if(Objects.equals(accounts.get(code).getCardId(),opposite)){
                LOGGER.warn("{}转账失败，不能给自己转账", accounts.get(code).getUserName());
                System.out.println("您不能给自己转账哦~~~");
                return;
            }
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(accounts.get(i).getCardId(),opposite)){
                    char zi = accounts.get(i).getUserName().charAt(0);
                    accounts.get(i).setUserName(accounts.get(i).getUserName().replace(accounts.get(i).getUserName().charAt(0),'*'));
                    LOGGER.info("已模糊姓氏");
                    System.out.println("请您输入[" + accounts.get(i).getUserName() + "的姓氏]");
                    accounts.get(i).setUserName(accounts.get(i).getUserName().replace(accounts.get(i).getUserName().charAt(0),zi));
                    LOGGER.info("已接触姓氏模糊");
                    String xs = sc.next();
                    if(xs.matches(".")&&Objects.equals(xs.charAt(0),accounts.get(i).getUserName().charAt(0))){
                        LOGGER.info("{}姓氏输入成功", accounts.get(code).getUserName());
                        break OUT;
                    } else {
                        LOGGER.warn("{}转账失败，用户输入的姓氏有误", accounts.get(code).getUserName());
                        System.out.println("您输入的信息有误~~");
                        return;
                    }
                }else if(i == accounts.size()-1){
                    LOGGER.warn("{}转账失败，系统中不存在这个卡号", accounts.get(code).getUserName());
                    System.out.println("系统中不存在这个卡号,请重新输入：");
                    return;
                }
            }
        }
        System.out.println("请您输入转账金额：");
        while (true){
            try {
                sendMoneyInput(code,opposite);
                break;
            } catch (Exception e) {
                LOGGER.error("{}转账失败，请输入正确的数字", accounts.get(code).getUserName());
                System.out.println("请输入正确的数字！");
            }
        }
    }

    public void sendMoneyInput(int code,String opposite) throws Exception{
        if (!lock.tryLock()){
            LOGGER.error("该用户正在操作，已锁");
            System.out.println("该账户正在进行转账操作,请稍后~~");
            return;
        }
        lock.lock();
        LOGGER.info("已上锁");
        Scanner sc = new Scanner(System.in);
        while (true){
            double money = sc.nextDouble();
            if(accounts.get(code).getMoney() < money){
                LOGGER.warn("{}转账失败，余额不足", accounts.get(code).getUserName());
                System.out.println("您的余额不足，您最多可以转账：" + accounts.get(code).getMoney() + "元,请重新输入：");
            }else if (accounts.get(code).getQuotaMoney() < money){
                LOGGER.warn("{}转账失败，超过限额", accounts.get(code).getUserName());
                System.out.println("您的额度为" + accounts.get(code).getQuotaMoney() + "元,您最多可转账为额度的上限");
            }else {
                for (Account account : accounts) {
                    LOGGER.info("{}正在转账", accounts.get(code).getUserName());
                    if (Objects.equals(account.getCardId(), opposite)) {
                        account.setMoney(account.getMoney() + money);
                        accounts.get(code).setMoney(accounts.get(code).getMoney() - money);
                        break;
                    }
                }
                System.out.println("转账成功！您的账户还剩余" + accounts.get(code).getMoney() + "元");
                break;
            }
        }
        updateLogs();
        lock.unlock();
        visitAccount(code);
        LOGGER.info("{}成功转账，并刷新了二进制日志与注册表日志，解锁，而且查看了修改后的信息", accounts.get(code).getUserName());
    }

    public void changAccount(int code) throws Exception{
        System.out.println("====================用户修改密码=======================");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入当前的密码：");
        if (!lock.tryLock()){
            LOGGER.error("用户正在操作，已锁");
            System.out.println("该账户正在进行更改密码的操作,请稍后~~");
            return;
        }
        lock.lock();
        LOGGER.info("已上锁");
        while (true){
            String password = sc.next();
            if(Objects.equals(password,accounts.get(code).getPassword())){
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassword = sc.next();
                    if (newPassword.matches("[0-9a-zA-Z]{5,20}")){
                        if(Objects.equals(newPassword,accounts.get(code).getPassword())){
                            LOGGER.warn("{}更改密码失败，不能更改为正在使用的密码", accounts.get(code).getUserName());
                            System.out.println("您不能更改为正在使用的密码");
                            lock.unlock();
                            changAccount(code);
                            LOGGER.info("已解锁，并回调该函数");
                            return;
                        }
                        System.out.println("请再次输入新密码：");
                        String newNewPassword = sc.next();
                        if (Objects.equals(newPassword, newNewPassword)) {
                            accounts.get(code).setPassword(newPassword);
                            System.out.println("恭喜您，您的密码修改成功了，请重新登录~~");
                            updateLogs();
                            lock.unlock();
                            LOGGER.info("{}更改密码成功，并刷新了二进制日志与注册表日志，解锁，须重新登陆", accounts.get(code).getUserName());
                        } else {
                            LOGGER.warn("{}更改密码失败，两次输入的密码不一致", accounts.get(code).getUserName());
                            System.out.println("两次输入的新密码不一致！");
                            lock.unlock();
                            changAccount(code);
                            LOGGER.info("已解锁，并回调该函数");
                        }
                        return;
                    }else {
                        LOGGER.warn("{}更改密码失败，用户未输入5到20位纯数字或字母", accounts.get(code).getUserName());
                        System.out.println("请输入5到20位数字或字母！请重新输入：");
                    }
                }
            }else {
                LOGGER.warn("{}用户输入的密码有误", accounts.get(code).getUserName());
                System.out.println("您输入的密码不正确,请重新输入：");
            }
        }
    }

    public void deleteAccount(int code) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("==================用户销户================");
        System.out.println("您真的要销户吗？y/n");
        if (!lock.tryLock()){
            LOGGER.error("用户正在操作，已锁");
            System.out.println("该账户正在进行销户操作,您无法操作！！！");
            return;
        }
        lock.lock();
        LOGGER.info("已上锁");
        while (true) {
            String confirm = sc.next();
            if(Objects.equals(confirm,"n")){
                System.out.println("好的，当前账户继续保留");
                lock.unlock();
                LOGGER.warn("{}用户取消销户并解锁，且回到了控制台", accounts.get(code).getUserName());
                works(code);
                break;
            } else if (Objects.equals(confirm,"y") && accounts.get(code).getMoney() > 0) {
                System.out.println("您账户中还有钱没有取完，不允许销户~~");
                lock.unlock();
                LOGGER.warn("{}用户账上有余额无法销户，解锁且回到了控制台", accounts.get(code).getUserName());
                works(code);
                break;
            } else if (Objects.equals(confirm,"y")) {
                LOGGER.info("{}用户正在确认是否销户", accounts.get(code).getUserName());
                System.out.println("请再次确认是否销户 y/n");
                if (Objects.equals(sc.next(),"y")){
                    System.out.println("您的账户销户完成~~");
                    accounts.remove(code);
                    updateLogs();
                    lock.unlock();
                    LOGGER.info("{}成功销户，并刷新了二进制日志与注册表日志，解锁", accounts.get(code).getUserName());
                }else {
                    System.out.println("好的，当前账户继续保留");
                    lock.unlock();
                    LOGGER.info("{}用户取消销户并解锁，且回到了控制台", accounts.get(code).getUserName());
                    works(code);
                }
                break;
            }else {
                LOGGER.warn("{}用户输入的信息有误", accounts.get(code).getUserName());
                System.out.println("您输入的信息有误，请重新输入：");
            }
        }
    }

    public StringBuilder randomCardId(){
        lock.lock();
        LOGGER.info("随机卡号已上锁");
        Random r = new Random();
        String ku = "123456789";
        StringBuilder id = new StringBuilder();
        for (int i = 1; i <= 8;i++) {
            LOGGER.info("正在生成随机卡号");
            id.append(ku.charAt(r.nextInt(ku.length())));
        }

        if (accounts.isEmpty()){
            return id;
        }else {
            for (Account account : accounts) {
                if (Objects.equals(account.getCardId(), id.toString())) {
                    LOGGER.warn("生成随机卡号的已被使用，回调函数重新生成");
                    randomCardId();
                    break;
                }
            }
        }
        lock.unlock();
        LOGGER.info("随机卡号已解锁");
        return id;
    }

    public void stopOOS(){
        if (oos != null){
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopOIS(){
        if (ois != null){
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateLogs() throws Exception{
        //清空数据并对象序列化
        stopOOS();
        oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt",false)));
        oos.writeObject(accounts);
        oos.flush();
        //刷新流

        //根据txt二进制文件转换为注册日志
        TranslateToRegisterLog.registerLog();
    }
}
