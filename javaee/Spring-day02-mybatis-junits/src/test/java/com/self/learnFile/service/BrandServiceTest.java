package com.self.learnFile.service;

import com.self.learnFile.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BrandServiceTest {
    @Autowired
    @Qualifier("brandService")
    private BrandService brandService;

    @Test
    public void testSelectAll() {
        brandService.selectAll();
    }

    @Test
    public void testSelectById() {
        brandService.selectById(2);
    }
}
