package com.springbootFinal.mapper;


import com.springbootFinal.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    boolean updateOne(Brand brand);
    boolean insert(Brand brand);
    boolean deleteById(int id);
}
