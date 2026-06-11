package com.self.learnFile.mapper;

import com.self.learnFile.pojo.User;

import java.util.List;

public interface UsersMapper {
    List<User> selectAll();
    int updateOne();
}
