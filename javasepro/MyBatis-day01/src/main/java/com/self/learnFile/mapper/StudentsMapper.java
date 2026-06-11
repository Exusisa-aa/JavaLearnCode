package com.self.learnFile.mapper;

import com.self.learnFile.pojo.Student;

import java.util.List;

public interface StudentsMapper {
    List<Student> selectAll();
}
