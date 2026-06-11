package com.self.learnFile.service.Impl;

import com.self.learnFile.mapper.BrandMapper;
import com.self.learnFile.pojo.Brand;
import com.self.learnFile.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    @Qualifier("brandMapper")
    private BrandMapper brandMapper;

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand selectById(int id) {
        return brandMapper.selectById(id);
    }

    @Override
    public void updateOne(Map<Object, Object> map) {
        brandMapper.updateOne(map);
//        int i = 1/0;
    }

}
