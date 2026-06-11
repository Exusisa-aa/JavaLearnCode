package com.self.learnFile.mapper;

import com.self.learnFile.pojo.Brand;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    List<Brand> selectByCondition(Map<Object,Object> map);
    List<Brand> selectByDynamicCondition(Map<Object,Object> map);
    List<Brand> selectByStaticCondition(Map<Object,Object> map);

    void insertOne(Brand brand);

    void updateStatic(Brand brand);
    void updateDynamic(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

}
