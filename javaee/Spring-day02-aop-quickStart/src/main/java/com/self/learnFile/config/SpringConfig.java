package com.self.learnFile.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.self.learnFile.service", "com.self.learnFile.aop"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
