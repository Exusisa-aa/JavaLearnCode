package com.springbootFinal.controller;

import com.springbootFinal.exception.BusinessException;
import com.springbootFinal.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    @ExceptionHandler(SystemException.class)
    public Result handleSystemException(SystemException ex){
        //记录日志（错误堆栈）
        //发送邮件给开发人员
        //发送短信给运维人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex){
        //记录日志（错误堆栈）
        //发送邮件给开发人员
        //发送短信给运维人员
        return new Result(500,null,"程序异常（兜底异常）");
    }
}
