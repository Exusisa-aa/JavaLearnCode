package com.springbootFinal.controller;

import com.springbootFinal.pojo.Brand;
import com.springbootFinal.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    @Qualifier("brandService")
    private BrandService brandService;

    @GetMapping
    public Result selectAll(){
        List<Brand> brands = brandService.selectAll();
        Integer code = brands != null ? Code.SELECT_OK.getCode() : Code.SELECT_ERR.getCode();
        String message = brands != null ? "获取数据成功" : "获取数据失败";
        return new Result(code, brands, message);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id){
        Brand brand = brandService.selectById(id);
        Integer code = brand != null ? Code.SELECT_OK.getCode() : Code.SELECT_ERR.getCode();
        String message = brand != null ? "获取数据成功" : "获取数据失败";
        return new Result(code, brand, message);
    }

    @PutMapping
    public Result updateOne(@RequestBody Brand brand){
        Boolean flag = brandService.updateOne(brand);
        Integer code = flag ? Code.UPDATE_OK.getCode() : Code.UPDATE_ERR.getCode();
        String message = flag ? "更新数据成功" : "更新数据失败";
        return new Result(code, flag, message);
    }

    @PostMapping
    public Result insert(@RequestBody Brand brand){
        Boolean flag = brandService.insert(brand);
        Integer code = flag ? Code.INSERT_OK.getCode() : Code.INSERT_ERR.getCode();
        String message = flag ? "插入数据成功" : "插入数据失败";
        System.out.println(brand.getId());
        return new Result(code, flag, message);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id){
        Boolean flag = brandService.deleteById(id);
        Integer code = flag ? Code.DELETE_OK.getCode() : Code.DELETE_ERR.getCode();
        String message = flag ? "删除数据成功" : "删除数据失败";
        return new Result(code, flag, message);
    }
}
