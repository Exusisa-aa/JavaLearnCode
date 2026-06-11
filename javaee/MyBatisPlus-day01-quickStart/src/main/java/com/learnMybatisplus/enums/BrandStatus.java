package com.learnMybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BrandStatus {
    OPEN(1,"启用"),
    CLOSE(2,"禁用");

    @EnumValue
    private final Integer value;
    @JsonValue
    private final String meaning;

    BrandStatus(Integer value, String meaning) {
        this.value = value;
        this.meaning = meaning;
    }

    public Integer getValue() {
        return value;
    }

    public String getMeaning() {
        return meaning;
    }
}
