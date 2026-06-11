package com.learnSpringMVC;


import com.learnSpringMVC.config.SpringConfig;
import com.learnSpringMVC.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
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
