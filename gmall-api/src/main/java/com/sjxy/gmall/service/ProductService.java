package com.sjxy.gmall.service;

import com.sjxy.gmall.bean.PmsProductInfo;

import java.util.List;

public interface ProductService {
    List<PmsProductInfo> spuList(String catalog3Id);
}
