package com.sjxy.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sjxy.gmall.bean.PmsBaseAttrInfo;
import com.sjxy.gmall.bean.PmsProductInfo;
import com.sjxy.gmall.manage.mapper.PmsProductInfoMapper;
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

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
}
