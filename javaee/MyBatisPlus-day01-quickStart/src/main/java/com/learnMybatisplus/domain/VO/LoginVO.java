package com.learnMybatisplus.domain.VO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "登录响应视图对象")
public class LoginVO {
    @Schema(description = "员工ID", example = "1")
    private Integer empId;

    @Schema(description = "姓名", example = "张三")
    private String name;

    @Schema(description = "用户名", example = "admin")
    private String username;

    @Schema(description = "JWT访问令牌")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
