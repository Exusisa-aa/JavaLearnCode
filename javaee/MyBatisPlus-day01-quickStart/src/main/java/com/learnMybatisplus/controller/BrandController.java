package com.learnMybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learnMybatisplus.domain.pojo.Brand;
import com.learnMybatisplus.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id){
        Brand brand = brandService.getById(id);
        Integer code = brand != null ? Code.SELECT_OK.getCode() : Code.SELECT_ERR.getCode();
        String message = brand != null ? "获取数据成功" : "获取数据失败";
        return new Result(code, brand, message);
    }

    @GetMapping
    public Result selectAll(){
//        QueryWrapper<Brand> qw = new QueryWrapper<>();
//        qw.le("ordered",30).or().ge("ordered",100);

        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
//        lqw.select(Brand::getId, Brand::getBrandName);

        List<Brand> brands = brandService.list(lqw);
        Map<String,Object> map = new HashMap<>();
        map.put("data",brands);
        map.put("size",brands.size());
        Integer code = map.get("data") != null ? Code.SELECT_OK.getCode() : Code.SELECT_ERR.getCode();
        String message = map.get("data") != null ? "获取数据成功" : "获取数据失败";
        return new Result(code, map, message);
    }


    @PostMapping
    public Result insert(@RequestBody Brand brand){
        boolean flag = brandService.save(brand);
        Integer code = flag ? Code.INSERT_OK.getCode() : Code.INSERT_ERR.getCode();
        String message = flag ? "插入数据成功" : "插入数据失败";
        return new Result(code, flag, message);
    }

    @PutMapping()
    public Result updateById(@RequestBody Brand brand){
//        LambdaUpdateWrapper<Brand> luw = new LambdaUpdateWrapper<>();
//        luw.eq(Brand::getId,brand.getId()).set(Brand::getBrandName,brand.getBrandName());
//        brandService.update(luw);
        brand.setVersion(brandService.getById(brand.getId()).getVersion());
        boolean flag = brandService.updateById(brand);
        Integer code = flag ? Code.UPDATE_OK.getCode() : Code.UPDATE_ERR.getCode();
        String message = flag ? "更新数据成功" : "更新数据失败";
        return new Result(code, flag, message);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id){
        boolean flag = brandService.removeById(id);
        Integer code = flag  ? Code.DELETE_OK.getCode() : Code.DELETE_ERR.getCode();
        String message = flag  ? "删除数据成功" : "删除数据失败";
        return new Result(code, flag, message);
    }

    @DeleteMapping("/ids")
    public Result deleteByIds(@RequestBody List<Integer> ids){
        boolean flag = brandService.removeByIds(ids);
        Integer code = flag ? Code.DELETE_OK.getCode() : Code.DELETE_ERR.getCode();
        String message = flag  ? "删除数据成功" : "删除数据失败";
        return new Result(code, flag, message);
    }

    @GetMapping("/page")
    public Result selectPage(@RequestBody Map<String,Object> map){
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
        lqw.like(map.get("brandName") != null,Brand::getBrandName,map.get("brandName"));
        lqw.like(map.get("companyName") != null,Brand::getCompanyName,map.get("companyName"));


        IPage<Brand> result = brandService.page(new Page<>((Integer)map.get("page"),(Integer)map.get("size")),lqw);
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("当前页码值：",result.getCurrent());
        resultMap.put("每页显示数量：",result.getSize());
        resultMap.put("一共多少条数据：",result.getTotal());
        resultMap.put("一共多少页：",result.getPages());
        resultMap.put("data",result.getRecords());

        Integer code = result.getRecords().isEmpty() ? Code.SELECT_ERR.getCode() : Code.SELECT_OK.getCode();
        String message = result.getRecords().isEmpty() ? "获取数据失败" : "获取数据成功";
        return new Result(code, resultMap, message);
    }

    @GetMapping("/pageHelper")
    public Result selectByPageHelper(@RequestBody Map<String,Object> map){
        PageHelper.startPage((Integer) map.get("page"),(Integer) map.get("size"));
        List<Brand> brands = brandService.list(new LambdaQueryWrapper<>());
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("当前页码值：",pageInfo.getPageNum());
        resultMap.put("每页显示数量：",pageInfo.getPageSize());
        resultMap.put("一共多少条数据：",pageInfo.getTotal());
        resultMap.put("一共多少页：",pageInfo.getPages());
        resultMap.put("data",pageInfo.getList());
        return new Result(Code.SELECT_OK.getCode(), resultMap, "获取数据成功");
    }

    @GetMapping("/ids")
    public Result selectByIds(@RequestBody List<Integer> ids){
        List<Brand> brands = brandService.listByIds(ids);
        Integer code = brands != null ? Code.SELECT_OK.getCode() : Code.SELECT_ERR.getCode();
        String message = brands != null ? "获取数据成功" : "获取数据失败";
        return new Result(code, brands, message);
    }


}
