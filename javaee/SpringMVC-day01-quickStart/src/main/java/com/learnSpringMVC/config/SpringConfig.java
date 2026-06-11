package com.learnSpringMVC.config;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.learnSpringMVC.mapper","com.learnSpringMVC.pojo","com.learnSpringMVC.service","com.learnSpringMVC.aop"})
@PropertySource({"classpath:jdbc.properties"})
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {

}
