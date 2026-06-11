package com.self.learnFile.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


public class JdbcConfig {
    @Value("${driverClassNameForDruid}")
    private String driverClassName;
    @Value("${urlForDruid}")
    private String url;
    @Value("${usernameForDruid}")
    private String username;
    @Value("${passwordForDruid}")
    private String password;
    @Bean("druidDataSource")
    public DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
