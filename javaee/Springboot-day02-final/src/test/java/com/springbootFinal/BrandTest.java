package com.springbootFinal;


import com.springbootFinal.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandTest {
    @Autowired
    @Qualifier("brandService")
    private BrandService brandService;

    @Test
    public void testSelectAll(){
        System.out.println(brandService.selectAll());
    }

    @Test
    public void testSelectById(){
        System.out.println(brandService.selectById(1));
    }



}
