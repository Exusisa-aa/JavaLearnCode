package com.learnMybatisplus.domain.pojo;



import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.learnMybatisplus.enums.BrandStatus;
import org.springframework.stereotype.Repository;

@Repository("brand")
@TableName(value = "tb_brand",autoResultMap = true)
public class Brand {
    // id 主键
//    @TableId(type = IdType.AUTO)
    private Integer id;
    // 品牌名称
    @TableField(value = "brand_name")
    private String brandName;
    // 企业名称
    @TableField(value = "company_name")
    private String companyName;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：2：禁用  1：启用
    private BrandStatus status;
    // 逻辑删除
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    //乐观锁
    @Version
    private Integer version;

    @TableField(value = "test_info",typeHandler = JacksonTypeHandler.class)
    private TestInfo testInfo;

//    @TableField(value = "pwd",select = false)
//    private String password;
//    @TableField(exist = false)
//    private Integer online;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BrandStatus getStatus() {
        return status;
    }

    public void setStatus(BrandStatus status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public TestInfo getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
