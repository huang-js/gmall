package com.sjxy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sjxy.gmall.bean.PmsBaseCatalog1;
import com.sjxy.gmall.bean.PmsBaseCatalog2;
import com.sjxy.gmall.bean.PmsBaseCatalog3;
import com.sjxy.gmall.service.PmsBaseCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName PmsBaseCatelogController
 * @Desciptionn TODO
 * @Author 老黄
 * @Date 2019/12/29 22:31
 * @Version 1.0
 **/
@Controller
@CrossOrigin
public class PmsBaseCatalogController {
    @Reference
    PmsBaseCatalogService pmsBaseCatalogService;

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3s =  pmsBaseCatalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2s =  pmsBaseCatalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1s =  pmsBaseCatalogService.getCatalog1();
        return catalog1s;
    }

}
