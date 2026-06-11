package com.self.ATMproject;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class ATM {

    ArrayList<Account> accounts = new ArrayList<>();
    public ATM(){

    }


    public void start(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎登录ATM银行系统==========================================");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("3.退出系统");
            System.out.print("请选择你要操作的命令：");
            switch (sc.next()){
                case "1" :
                    if(accounts.size() == 0){
                        System.out.println("您好，当前系统无账户~~");
                        break;
                    }
                    works(loginIn());
                    break;
                case "2" :
                    creatAccount();
                    break;
                case "3" :
                    System.out.println("已退出系统，欢迎下次再来~~");
                    return;
                default:
                    System.out.println("您输入的指令有误！！");
                    break;
            }
        }
    }

    public void creatAccount(){
        Account a = new Account();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入账户的用户名：");
        a.setUserName(sc.next());
        System.out.println("请输入您的性别：");
        while (true) {
            String sex = sc.next();
            if(Objects.equals('男',sex.charAt(0)) || Objects.equals('女',sex.charAt(0))){
                a.setSex(sex.charAt(0));
                break;
            }else {
                System.out.println("您输入的性别有误，请重新输入：");
            }
        }
        while (true) {
            System.out.println("请您输入账户密码：");
            String password = sc.next();
            System.out.println("请再次输入您的账户密码：");
            String passwordText = sc.next();
            if(Objects.equals(passwordText,password)){
                a.setPassword(password);
                break;
            }else {
                System.out.println("您输入的两次密码不一致，请重新确认！");
            }
        }
        System.out.println("请输入账户每次取现限额：");
        a.setQuotaMoney(sc.nextDouble());
        String ku = "123456789";
        String id = "";
        for (int i = 1; i <= 8;i++) {
            id += ku.charAt(r.nextInt(ku.length()));
        }
        a.setCardId(id);
        accounts.add(a);
        if(Objects.equals(a.getSex(),'男')) {
            System.out.println("恭喜您," + a.getUserName() + "先生,您开户成功," + "您的卡号是" + a.getCardId() + ",请妥善保管您的卡号");
        }
        if(Objects.equals(a.getSex(),'女')){
            System.out.println("恭喜您," + a.getUserName() + "女士,您开户成功," + "您的卡号是" + a.getCardId() + ",请妥善保管您的卡号");
        }
    }

    public int loginIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================系统登录操作==================================");
        System.out.println("请输入您登录的卡号：");
        String idIndex = "";
        boolean flag1 = true;
        while (flag1){
            String id = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(id,accounts.get(i).getCardId())){
                   flag1 = false;
                   idIndex = id;
                   break;
                } else if (i == accounts.size()-1) {
                    System.out.println("系统中不存在该账户卡号,请重新输入：");
                    break;
                }
            }
        }
        boolean flag2 = true;
        int j = 0;
        System.out.println("请输入您的登录密码：");
        while (flag2){
            String password = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(password,accounts.get(i).getPassword()) && Objects.equals(idIndex,accounts.get(i).getCardId())){
                    if(Objects.equals(accounts.get(i).getSex(),'男')) {
                        System.out.println("恭喜您" + accounts.get(i).getUserName() + "先生，您已进入系统，您的卡号是：" + accounts.get(i).getCardId());
                        flag2 = false;
                        j = i;
                        break;
                    }
                    if(Objects.equals(accounts.get(i).getSex(),'女')) {
                        System.out.println("恭喜您" + accounts.get(i).getUserName() + "女士，您已进入系统，您的卡号是：" + accounts.get(i).getCardId());
                        flag2 = false;
                        j = i;
                        break;
                    }
                }else if(i == accounts.size()-1){
                    System.out.println("您输入的密码有误，请重新输入：");
                    break;
                }
            }
        }
        return j;
    }

    public void works(int code){
        Scanner sc = new Scanner(System.in);
        while (true){
            if(Objects.equals(accounts.get(code).getSex(),'男')) {
                System.out.println("====================" + accounts.get(code).getUserName() + "先生，您可以办理以下业务=====================");
            }
            if(Objects.equals(accounts.get(code).getSex(),'女')) {
                System.out.println("====================" + accounts.get(code).getUserName() + "女士，您可以办理以下业务=====================");
            }
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
                visitAccount(code);
                break;
            case "2":
                saveAccount(code);
                break;
            case "3":
                takeAccount(code);
                break;
            case "4":
                sendMoney(code);
                break;
            case "5":
                changAccount(code);
                return;
            case "6":
                System.out.println("您已成功退出登录，欢迎下次再来~~");
                return;
            case "7":
                deleteAccount(code);
                return;
            default:
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
    }

    public void saveAccount(int code){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================用户存钱操作=============================");
        System.out.println("请输入您的存款金额：");
        accounts.get(code).setMoney(accounts.get(code).getMoney() + sc.nextDouble());
        System.out.println("恭喜您存钱成功，当前账户信息如下");
        visitAccount(code);
    }

    public void takeAccount(int code){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================用户取钱操作=============================");
        if(accounts.get(code).getMoney() == 0){
            System.out.println("当前账户没钱，不能取款");
            return;
        }
        System.out.println("请输入您的取款金额：");
        while (true) {
            double money = sc.nextDouble();
            if(money > accounts.get(code).getQuotaMoney()){
                System.out.println("您当前取款金额超过每次限额，每次最多可取" + accounts.get(code).getQuotaMoney() + "元,请重新输入：");
            }else if(accounts.get(code).getMoney() < money){
                System.out.println("余额不足，您的账户目前的总余额为" + accounts.get(code).getMoney() + "元,请再次输入您的取款余额：");
            }
            else {
                accounts.get(code).setMoney(accounts.get(code).getMoney() - money);
                System.out.println("恭喜您，取钱" + money + "元" + "，成功！");
                visitAccount(code);
                break;
            }
        }
    }

    public void sendMoney(int code){
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================用户转账操作=========================");
        if(accounts.size() < 2){
            System.out.println("当前系统中不足两个用户，不能进行转账，请去开户吧~~");
            return;
        }
        if(accounts.get(code).getMoney() == 0){
            System.out.println("您自己都没钱了，就别转了吧~~");
            return;
        }
        String opposite = "";
        boolean flag2 = true;
        while (flag2){
            System.out.println("请您输入对方卡号：");
            opposite = sc.next();
            if(Objects.equals(accounts.get(code).getCardId(),opposite)){
                System.out.println("您不能给自己转账哦~~~");
                return;
            }
            for (int i = 0; i < accounts.size(); i++) {
                if(Objects.equals(accounts.get(i).getCardId(),opposite)){
                    char zi = accounts.get(i).getUserName().charAt(0);
                    accounts.get(i).setUserName(accounts.get(i).getUserName().replace(accounts.get(i).getUserName().charAt(0),'*'));
                    System.out.println("请您输入[" + accounts.get(i).getUserName() + "的姓氏]");
                    accounts.get(i).setUserName(accounts.get(i).getUserName().replace(accounts.get(i).getUserName().charAt(0),zi));
                    String xs = sc.next();
                    if(Objects.equals(xs.charAt(0),accounts.get(i).getUserName().charAt(0))){
                        flag2 = false;
                        break;
                    } else {
                        System.out.println("您输入的信息有误~~");
                        break;
                    }
                }else if(i == accounts.size()-1){
                    System.out.println("系统中不存在这个卡号,请重新输入：");
                    break;
                }
            }
        }
        System.out.println("请您输入转账金额：");
        while (true){
            double money = sc.nextDouble();
            if(accounts.get(code).getMoney() < money){
                System.out.println("您的余额不足，您最多可以转账：" + accounts.get(code).getMoney() + "元,请重新输入：");
            }else {
                for (int i = 0; i < accounts.size(); i++) {
                    if(Objects.equals(accounts.get(i).getCardId(),opposite)){
                        accounts.get(i).setMoney(accounts.get(i).getMoney() + money);
                        break;
                    }
                }
                accounts.get(code).setMoney(accounts.get(code).getMoney() - money);
                System.out.println("转账成功！您的账户还剩余" + accounts.get(code).getMoney() + "元");
                break;
            }
        }
        visitAccount(code);
    }

    public void changAccount(int code){
        System.out.println("====================用户修改密码=======================");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入当前的密码：");
        while (true){
            String password = sc.next();
            if(Objects.equals(password,accounts.get(code).getPassword())){
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassword = sc.next();
                    if(Objects.equals(newPassword,accounts.get(code).getPassword())){
                        System.out.println("您不能更改为正在使用的密码");
                        changAccount(code);
                        return;
                    }
                    System.out.println("请再次输入新密码：");
                    String newNewPassword = sc.next();
                    if (Objects.equals(newPassword, newNewPassword)) {
                        accounts.get(code).setPassword(newPassword);
                        System.out.println("恭喜您，您的密码修改成功了~~");
                        return;
                    } else {
                        System.out.println("您输入的新密码不一致！");
                    }
                }
            }else {
                System.out.println("您输入的密码不正确,请重新输入：");
            }
        }
    }

    public void deleteAccount(int code){
        Scanner sc = new Scanner(System.in);
        System.out.println("==================用户销户================");
        System.out.println("您真的要销户码？y/n");
        while (true) {
            String confirm = sc.next();
            if(Objects.equals(confirm,"n")){
                System.out.println("好的，当前账户继续保留");
                works(code);
                break;
            } else if (Objects.equals(confirm,"y") && accounts.get(code).getMoney() > 0) {
                System.out.println("您账户中还有钱没有取完，不允许销户~~");
                works(code);
                break;
            } else if (Objects.equals(confirm,"y")) {
                System.out.println("您的账户销户完成~~");
                accounts.remove(code);
                break;
            }else {
                System.out.println("您输入的信息有误，请重新输入：");
            }
        }
    }
}
