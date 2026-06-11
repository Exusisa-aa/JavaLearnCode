package com.learnMybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.learnMybatisplus.domain.pojo.Brand;
import com.learnMybatisplus.enums.BrandStatus;
import com.learnMybatisplus.service.BrandService;
import com.learnMybatisplus.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MyBatisPlusDay01QuickStartApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void testLock() {
        Brand brand1 = brandService.getById(3);
        Brand brand2 = brandService.getById(3);

        brand1.setOrdered(50);
        brandService.updateById(brand1);

        brand2.setOrdered(200);
        brandService.updateById(brand2);


    }

    @Test
    public void testToken() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","小城");
        String token = JwtUtils.generateToken(map);
        System.out.println(token);
        Claims claims = JwtUtils.parseToken(token);
        System.out.println(claims.get("id"));
        System.out.println(claims.get("username"));
        System.out.println(claims.get("exp"));
        System.out.println(claims);
    }

//    @Test
//    public void testBatchInsert(){
//
//        long start = System.currentTimeMillis();
//        ArrayList<Brand> brands = new ArrayList<>();
//        for (int i = 0; i < 20000; i++){
//            Brand brand = new Brand();
//            brand.setBrandName("小城");
//            brand.setCompanyName("小城");
//            brand.setDescription("小城");
//            brand.setOrdered(1);
//            brand.setStatus(BrandStatus.OPEN);
//            brands.add(brand);
//            if(brands.size() == 1000){
//                brandService.saveBatch(brands);
//                brands.clear();
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start) + "毫秒");
//
//
//    }

    @Test
    public void delete(){
        LambdaQueryWrapper<Brand> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Brand::getBrandName,"小城");
        brandService.remove(queryWrapper);
    }

}
