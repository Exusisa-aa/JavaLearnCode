package com.self.learnFile.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.self.learnFile.pojo.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DruidConfig {
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean("druid")
    public DruidDataSource druidDataSource(Worker maintainer){
        System.out.println(maintainer);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
