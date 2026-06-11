package com.self.learnFile.test;

import com.self.learnFile.mapper.BrandMapper;
import com.self.learnFile.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws Exception{
        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql语句
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testSelectById() throws Exception{
        int id = 1;

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql语句
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testSelectByCondition() throws Exception{
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

        Map<Object,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql语句
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testSelectByDynamicCondition() throws Exception{
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

        Map<Object,Object> map = new HashMap<>();
        map.put("status",status);
//        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql语句
        List<Brand> brands = brandMapper.selectByDynamicCondition(map);
        System.out.println(brands);

        //释放资源
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void testSelectByStaticCondition() throws Exception{
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

        Map<Object,Object> map = new HashMap<>();
        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql语句
        List<Brand> brands = brandMapper.selectByStaticCondition(map);
        System.out.println(brands);

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testInsertOne() throws Exception{
        int status = 1;
        String companyName = "大疆";
        String brandName = "大疆无人机";
        int ordered = 100;
        String description = "飞起来";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行sql语句
        brandMapper.insertOne(brand);
        Integer id = brand.getId();
        System.out.println("id:"+id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void testUpdateStatic() throws Exception{
        int status = 0;
        String companyName = "大疆";
        String brandName = "大疆无人机";
        int ordered = 10030;
        String description = "大疆无人机飞起来";
        int id = 4;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行sql语句
        brandMapper.updateStatic(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testUpdateDynamic() throws Exception{
        int status = 1;
//        String companyName = "大疆";  不存在不修改
        String brandName = ""; //为空不修改
        int ordered = 200;
        String description = ""; //为空不修改
        int id = 4;

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行sql语句
        brandMapper.updateDynamic(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testDeleteByIds() throws Exception{
        int[] ids = {4,5,6};

        //创建SqlSessionFactory对象,加载mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得Mapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行sql语句
        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();
    }



}
