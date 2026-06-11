package com.learnMybatisplus.service.Impl;


import com.learnMybatisplus.mapper.LoginMapper;
import com.learnMybatisplus.domain.pojo.LoginInfo;
import com.learnMybatisplus.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;

    private final TransactionTemplate transactionTemplate;

    @Override
    public LoginInfo selectByUsernameAndPassword(String username, String password) {
        return transactionTemplate.execute(status -> loginMapper.selectByUsernameAndPassword(username,password));
    }
}
