package com.self.learnFile.mapper;

import com.self.learnFile.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    void updateOne(Map<Object, Object> map);
}
