package com.self.jdbc.learn.statement.executeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TryToTest {
    public static void main(String[] args) {
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取链接对象，需要数据库对应的地址，账户名，密码
            Connection connection = DriverManager.getConnection(Message.URL.getMessage(), Message.USERNAME.getMessage(), Message.PASSWORD.getMessage());

            //3.定义sql语句
            String sql = "select * from account";

            //4.获取执行对象
            Statement statement = connection.createStatement();

            //5.执行sql语句,返回影响行数
            ResultSet resultSet = statement.executeQuery(sql);

            //6.处理执行结果
            ArrayList<Account> accounts = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double money = resultSet.getDouble("money");

                Account account = new Account(id,name,money);
                accounts.add(account);
            }

            accounts.forEach(System.out::println);

            //释放资源
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
