package com.self.learnFile.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.self.learnFile.service","com.self.learnFile.pojo"})
@PropertySource({"classpath:Druid.properties"})
public class SpringConfig {
}
