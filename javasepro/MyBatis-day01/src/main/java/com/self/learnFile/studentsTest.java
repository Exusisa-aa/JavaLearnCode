package com.self.learnFile;

import com.self.learnFile.mapper.StudentsMapper;
import com.self.learnFile.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class studentsTest {
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
        StudentsMapper studentsMapper = sqlSession.getMapper(StudentsMapper.class);
        //执行sql语句
        List<Student> students = studentsMapper.selectAll();
        System.out.println(students);

        //释放资源
        sqlSession.close();
        try {
            inputStream.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
