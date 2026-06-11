package com.learnMybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learnMybatisplus.domain.pojo.Brand;
import com.learnMybatisplus.mapper.BrandMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

// 为所有方法开启事务，原理：将每个方法下的所有事务合并为一个Spring事务
@Transactional(rollbackFor = {IOException.class},
                propagation = Propagation.REQUIRES_NEW)
public interface BrandService extends IService<Brand> {

}
