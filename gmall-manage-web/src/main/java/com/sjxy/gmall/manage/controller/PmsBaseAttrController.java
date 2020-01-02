package com.sjxy.gmall.manage.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sjxy.gmall.bean.PmsBaseAttrInfo;
import com.sjxy.gmall.bean.PmsBaseAttrValue;
import com.sjxy.gmall.service.PmsBaseAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName PmsBaseAttrController
 * @Desciptionn TODO
 * @Author 老黄
 * @Date 2019/12/30 15:49
 * @Version 1.0
 **/
@Controller
@CrossOrigin
public class PmsBaseAttrController {

    @Reference
    PmsBaseAttrService pmsBaseAttrService;

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue>  pmsBaseAttrValues = pmsBaseAttrService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }

    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
            pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
        return "successs";
    }

    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo>  pmsBaseAttrInfos = pmsBaseAttrService.getAttrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

}
