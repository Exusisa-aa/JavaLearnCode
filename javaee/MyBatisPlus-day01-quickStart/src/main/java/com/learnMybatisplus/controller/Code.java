package com.learnMybatisplus.controller;

public enum Code {
    INSERT_OK(40021),
    DELETE_OK(40031),
    UPDATE_OK(40041),
    SELECT_OK(40011),
    UPLOAD_OK(40051),
    LOGIN_OK(40061),
    LOGIN_ERR(40060),
    INSERT_ERR(40020),
    DELETE_ERR(40030),
    UPDATE_ERR(40040),
    SELECT_ERR(40010),
    UPLOAD_ERR(40050);

    private final Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
