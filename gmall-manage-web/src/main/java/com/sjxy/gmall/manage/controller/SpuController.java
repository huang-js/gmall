package com.sjxy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sjxy.gmall.bean.PmsBaseAttrInfo;
import com.sjxy.gmall.bean.PmsProductImage;
import com.sjxy.gmall.bean.PmsProductInfo;
import com.sjxy.gmall.bean.PmsProductSaleAttr;
import com.sjxy.gmall.manage.uitl.PmsUploadUtil;
import com.sjxy.gmall.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
public class SpuController {
    @Reference
    ProductService productService;

    @RequestMapping("/spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){
        List<PmsProductImage>  pmsProductImages = productService.spuImageList(spuId);
        return pmsProductImages;
    }

    @RequestMapping("/spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){
        List<PmsProductSaleAttr>  pmsProductSaleAttrs = productService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = productService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        productService.saveSpuInfo(pmsProductInfo);
        return "successs";
    }

    //添加spu中的图片上传功能
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        //将图片或者音视频上传到分布式的文件存储系统
        String imageUri = PmsUploadUtil.uploadImage(multipartFile);
        //将图片的存储路径返回给页面
        System.out.println(imageUri);
        return imageUri;
    }
}
