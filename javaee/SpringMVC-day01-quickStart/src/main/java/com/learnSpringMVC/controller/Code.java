package com.learnSpringMVC.controller;

public enum Code {
    INSERT_OK(40021),
    DELETE_OK(40031),
    UPDATE_OK(40041),
    SELECT_OK(40011),
    INSERT_ERR(40020),
    DELETE_ERR(40030),
    UPDATE_ERR(40040),
    SELECT_ERR(40010);

    private final Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
