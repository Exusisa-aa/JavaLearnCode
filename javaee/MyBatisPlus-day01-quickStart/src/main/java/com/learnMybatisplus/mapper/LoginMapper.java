package com.learnMybatisplus.mapper;

import com.learnMybatisplus.domain.pojo.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from login_test lt where lt.username = #{username} and lt.password = #{password}")
    LoginInfo selectByUsernameAndPassword(String username, String password);
}
