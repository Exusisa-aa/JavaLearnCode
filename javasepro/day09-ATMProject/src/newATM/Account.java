package newATM;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {
    private String cardId;//卡号
    private String userName;//用户名
    private char sex;//性别
    private String password;//密码
    private double money;//余额
    private double quotaMoney;//取现额度
    private LocalDateTime time;//创建账户的时间

    public Account(){

    }

    public Account(String cardId, String userName, char sex, String password, double money, double quotaMoney, LocalDateTime time) {
        this.cardId = cardId;
        this.userName = userName;
        this.sex = sex;
        this.password = password;
        this.money = money;
        this.quotaMoney = quotaMoney;
        this.time = time;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardId='" + cardId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", quotaMoney=" + quotaMoney +
                ", time=" + time +
                '}';
    }
}
