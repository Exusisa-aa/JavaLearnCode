package com.self.jdbc.learn.basis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TryToTest {
    public static void main(String[] args) {
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取链接对象，需要数据库对应的地址，账户名，密码
            Connection connection = DriverManager.getConnection(Message.URL.getMessage(),Message.USERNAME.getMessage(), Message.PASSWORD.getMessage());

            //3.定义sql语句
            String sql = "update account set money = 30000 where id = 1";

            //4.获取执行对象
            Statement statement = connection.createStatement();

            //5.执行sql语句,返回影响行数
            int count = statement.executeUpdate(sql);

            //6.处理执行结果
            System.out.println(count);

            //释放资源
            statement.close();
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
