package com.sjxy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sjxy.gmall.bean.PmsBaseAttrInfo;
import com.sjxy.gmall.bean.PmsBaseAttrValue;
import com.sjxy.gmall.bean.PmsBaseSaleAttr;
import com.sjxy.gmall.service.PmsBaseAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PmsBaseAttrController
 * @Desciptionn TODO
 * @Author 老黄
 * @Date 2019/12/30 15:49
 * @Version 1.0
 * 有关平台属性操作都在这个类中
 **/
@Controller
@CrossOrigin
public class PmsBaseAttrController {
    @Reference
    PmsBaseAttrService pmsBaseAttrService;


    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr>  pmsBaseAttrInfos = pmsBaseAttrService.baseSaleAttrList();
        return pmsBaseAttrInfos;
    }

    //获取销售属性值列表
    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue>  pmsBaseAttrValues = pmsBaseAttrService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }

    //保存平台属性
    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
            pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
        return "successs";
    }

    //获取平台属性列表
    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo>  pmsBaseAttrInfos = pmsBaseAttrService.getAttrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

}
