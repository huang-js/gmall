package com.sjxy.gmall.service;

import com.sjxy.gmall.bean.PmsBaseAttrInfo;
import com.sjxy.gmall.bean.PmsBaseAttrValue;
import com.sjxy.gmall.bean.PmsBaseSaleAttr;
import com.sjxy.gmall.bean.PmsProductInfo;

import java.util.List;

public interface PmsBaseAttrService {
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

}
