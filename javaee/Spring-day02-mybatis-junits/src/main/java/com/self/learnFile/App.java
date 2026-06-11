package com.self.learnFile;

import com.self.learnFile.config.SpringConfig;
import com.self.learnFile.pojo.Brand;
import com.self.learnFile.service.BrandService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandService brandService = (BrandService) applicationContext.getBean("brandService");

        List<Brand> brands = brandService.selectAll();
        System.out.println(brands);
        Brand brand = brandService.selectById(2);
        System.out.println(brand);

        Map<Object, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("status",2);
        brandService.updateOne(map);
    }
}
