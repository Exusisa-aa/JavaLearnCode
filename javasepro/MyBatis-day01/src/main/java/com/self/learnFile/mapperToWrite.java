package com.self.learnFile;

import com.self.learnFile.mapper.UsersMapper;
import com.self.learnFile.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mapperToWrite {
    public static void main(String[] args) {
        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        //执行sql语句
        List<User> users = usersMapper.selectAll();
        System.out.println(users);
        usersMapper.updateOne();
        users = usersMapper.selectAll();
        System.out.println(users);
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        try {
            inputStream.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
