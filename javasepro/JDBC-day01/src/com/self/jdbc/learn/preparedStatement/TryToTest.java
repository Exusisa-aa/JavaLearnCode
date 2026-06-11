package com.self.jdbc.learn.preparedStatement;

import java.sql.*;

public class TryToTest {
    public static void main(String[] args) {
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取链接对象，需要数据库对应的地址，账户名，密码
            Connection connection = DriverManager.getConnection(Message.URL.getMessage(), Message.USERNAME.getMessage(), Message.PASSWORD.getMessage());

            //3.定义sql语句
            int id = 1;
            String name = "张三";

            String sql = "select * from account where id = ? and name = ?";

            //4.获取执行对象
            PreparedStatement statement = connection.prepareStatement(sql);

            //设置问号的值Z
            statement.setInt(1,id);
            statement.setString(2,name);

            //5.执行sql语句
            ResultSet resultSet = statement.executeQuery();

            //6.处理执行结果
            if(resultSet.next()){
                System.out.println("查找成功~~");
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getDouble("money"));
            }else {
                System.out.println("查找失败~~");
            }

            //释放资源
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
