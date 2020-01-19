package com.sjxy.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sjxy.gmall.bean.*;
import com.sjxy.gmall.manage.mapper.PmsProductImageMapper;
import com.sjxy.gmall.manage.mapper.PmsProductInfoMapper;
import com.sjxy.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.sjxy.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.sjxy.gmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Desciptionn TODO
 * @Author
 * @Date 2020/1/2 15:33
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
    //商品管理添加spu保存功能（spu属性值、销售属性列表、添加图片列表的保存）
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        pmsProductInfo.getId();

        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            PmsProductSaleAttr pmsProductSaleAttr1 = new PmsProductSaleAttr();
            pmsProductSaleAttr1.setProductId(pmsProductInfo.getId());
            pmsProductSaleAttr1.setSaleAttrId(pmsProductSaleAttr.getSaleAttrId());
            pmsProductSaleAttr1.setSaleAttrName(pmsProductSaleAttr.getSaleAttrName());
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr1);

            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                PmsProductSaleAttrValue pmsProductSaleAttrValue1 = new PmsProductSaleAttrValue();
                pmsProductSaleAttrValue1.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrValue1.setSaleAttrId(pmsProductSaleAttrValue.getSaleAttrId());
                pmsProductSaleAttrValue1.setSaleAttrValueName(pmsProductSaleAttrValue.getSaleAttrValueName());
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue1);
            }
        }


        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            PmsProductImage pmsProductImage1 = new PmsProductImage();
            pmsProductImage1.setProductId(pmsProductInfo.getId());
            pmsProductImage1.setImgName(pmsProductImage.getImgName());
            pmsProductImage1.setImgUrl(pmsProductImage.getImgUrl());
            pmsProductImageMapper.insertSelective(pmsProductImage1);
        }
    }
    //获取商品销售属性列表
    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        //获取关联的销售属性值
        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrs) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrValue> productSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(productSaleAttrValues);
        }
        return pmsProductSaleAttrs;
    }

    //获取spu的图片列表
    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        return pmsProductImageMapper.select(pmsProductImage);
    }
}
