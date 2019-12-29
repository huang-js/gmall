package com.sjxy.gmall.service;

import com.sjxy.gmall.bean.PmsBaseCatalog1;
import com.sjxy.gmall.bean.PmsBaseCatalog2;
import com.sjxy.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @ClassName PmsBaseCatalogService
 * @Desciptionn TODO
 * @Author
 * @Date 2019/12/29 22:34
 * @Version 1.0
 **/
public interface PmsBaseCatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
