package com.sjxy.gmall.service;

import com.sjxy.gmall.bean.PmsProductImage;
import com.sjxy.gmall.bean.PmsProductInfo;
import com.sjxy.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface ProductService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
