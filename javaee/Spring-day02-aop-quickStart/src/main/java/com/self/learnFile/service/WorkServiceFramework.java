package com.self.learnFile.service;

public interface WorkServiceFramework {
    void save();
    void delete();
    void update();
    void select();
    int selectCount();
    int selectByIdAndName(int id, String name);
}
