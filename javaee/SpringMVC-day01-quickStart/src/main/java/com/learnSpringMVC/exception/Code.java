package com.learnSpringMVC.exception;

public enum Code {
    BUSINESS_ERR(50050),
    SYSTEM_ERR(60060),
    SYSTEM_TIMEOUT_ERR(60061);

    private final Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
