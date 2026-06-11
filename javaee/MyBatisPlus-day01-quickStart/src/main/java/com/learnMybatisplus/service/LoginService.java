package com.learnMybatisplus.service;

import com.learnMybatisplus.mapper.LoginMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

//@Transactional(rollbackFor = {IOException.class},
//        propagation = Propagation.REQUIRES_NEW)
public interface LoginService extends LoginMapper {
}
