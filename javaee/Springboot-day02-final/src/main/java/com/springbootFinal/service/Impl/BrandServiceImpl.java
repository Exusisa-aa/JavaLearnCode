package com.springbootFinal.service.Impl;

import com.springbootFinal.exception.BusinessException;
import com.springbootFinal.exception.Code;
import com.springbootFinal.exception.SystemException;
import com.springbootFinal.mapper.BrandMapper;
import com.springbootFinal.pojo.Brand;
import com.springbootFinal.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    @Qualifier("brandMapper")
    private BrandMapper brandMapper;

    //查询所有
    @Override
    public List<Brand> selectAll() {
//        try{
//            int i = 1/0;
//        }catch (Exception e){
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR.getCode(), "系统异常（异常转换）", e);
//        }
        return brandMapper.selectAll();
    }

    //根据id查询
    @Override
    public Brand selectById(int id) {
        if(id <= 0){
            throw new BusinessException(Code.BUSINESS_ERR.getCode(),"id不能小于0");
        }


        return brandMapper.selectById(id);
    }

    //更新
    @Override
    public boolean updateOne(Brand brand) {
        brandMapper.updateOne(brand);
//        int i = 1/0;
        return true;
    }

    //添加
    @Override
    public boolean insert(Brand brand) {
        return brandMapper.insert(brand);
    }

    //删除
    @Override
    public boolean deleteById(int id) {
        return brandMapper.deleteById(id);
    }

}
