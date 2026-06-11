package com.learnMybatisplus.controller;


import com.learnMybatisplus.domain.DTO.LoginDTO;
import com.learnMybatisplus.domain.VO.LoginVO;
import com.learnMybatisplus.domain.pojo.LoginInfo;
import com.learnMybatisplus.service.LoginService;
import com.learnMybatisplus.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "登录管理", description = "用户登录相关接口")
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "用户登录", description = "根据用户名和密码进行登录，成功返回 JWT Token")
    @PostMapping
    public Result login(
            @Parameter(description = "登录信息", required = true)
            @RequestBody LoginDTO loginDTO){
        LoginInfo loginInfo = loginService.selectByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        //反向校验
        if(loginInfo == null){
            return new Result(Code.LOGIN_ERR.getCode(),null,"登录失败");
        }
        Map<String,Object> claims = new HashMap<>();
        claims.put("EmpId",loginInfo.getEmpId());
        claims.put("name",loginInfo.getName());
        String token = JwtUtils.generateToken(claims);
        loginInfo.setToken(token);
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(loginInfo, loginVO);

        return new Result(Code.LOGIN_OK.getCode(),loginVO,"登录成功");

    }
}
