package com.learnMybatisplus.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestInfo {
    private String name;
    private String gender;
    private Integer age;
}
