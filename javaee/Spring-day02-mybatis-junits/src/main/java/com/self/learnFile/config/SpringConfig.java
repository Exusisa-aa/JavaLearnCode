package com.self.learnFile.config;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.self.learnFile.config","com.self.learnFile.service", "com.self.learnFile.mapper","com.self.learnFile.pojo","com.self.learnFile.aop"})
@PropertySource({"classpath:jdbc.properties"})
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {

}
