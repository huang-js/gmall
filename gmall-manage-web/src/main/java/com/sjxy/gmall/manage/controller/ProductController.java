package com.sjxy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sjxy.gmall.bean.PmsProductInfo;
import com.sjxy.gmall.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName productController
 * @Desciptionn TODO
 * @Author lao黄
 * @Date 2020/1/2 15:28
 * @Version 1.0
 **/
@Controller
@CrossOrigin
public class ProductController {
    @Reference
    ProductService productService;

    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = productService.spuList(catalog3Id);
        return pmsProductInfos;
    }
}
