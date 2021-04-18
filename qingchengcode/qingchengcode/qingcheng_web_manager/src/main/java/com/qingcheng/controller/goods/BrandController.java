package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;


import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }


    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page,int size){
        return  brandService.findPage(page,size);
    }




    @PostMapping("/findPage")
    public PageResult<Brand>  findPage(@RequestBody Map searchMap,int page,int size ){
        return brandService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    /*对于增加数据应该有明确的返回值，告诉用户成功或者具体失败在哪里*/
    public Result add(@RequestBody  Brand brand){
        int x=1/0;
        brandService.add(brand);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody  Brand brand){
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }

}
