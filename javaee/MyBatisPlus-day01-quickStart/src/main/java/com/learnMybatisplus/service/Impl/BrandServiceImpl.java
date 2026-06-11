package com.learnMybatisplus.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learnMybatisplus.mapper.BrandMapper;
import com.learnMybatisplus.domain.pojo.Brand;
import com.learnMybatisplus.service.BrandService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service("brandService")
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements BrandService {

    private final BrandMapper brandMapper;


}
