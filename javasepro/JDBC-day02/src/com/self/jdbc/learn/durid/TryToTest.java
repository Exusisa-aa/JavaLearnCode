package com.self.jdbc.learn.durid;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class TryToTest {
    public static void main(String[] args) {
        try {
            //1.编辑连接池配置信息

            //2.加载连接池配置文件并获得链接池对象
            Properties properties = new Properties();
            properties.load(new FileInputStream("K:\\study\\java+JDBC\\java code\\javasepro\\JDBC-day02\\src\\com\\self\\jdbc\\learn\\Druid.properties"));

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();
            //3.定义sql语句
            int id = 1;
            String name = "张三";

            String sql = "select * from account where id = ? and name = ?";

            //4.获取执行对象
            PreparedStatement statement = connection.prepareStatement(sql);

            //设置问号的值
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
