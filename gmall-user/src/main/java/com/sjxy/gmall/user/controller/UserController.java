package com.sjxy.gmall.user.controller;

import com.sjxy.gmall.user.bean.UmsMember;
import com.sjxy.gmall.user.bean.UmsMemberReceiveAddress;
import com.sjxy.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Desciptionn TODO
 * @Author 老黄
 * @Date 2019/12/26 22:26
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    //查询全部会员信息
    @GetMapping("/member")
    @ResponseBody
    public List<UmsMember> findAllMember(){
        List<UmsMember> umsMemberList = userService.getAllMember();
        return umsMemberList;
    }

    //根据id查询会员信息
    @GetMapping("/member/{id}")
    @ResponseBody
    public UmsMember getMemberById(@PathVariable("id") String id){
        UmsMember umsMember = userService.getMemberById(id);
        return umsMember;
    }
    //更新会员信息
    @PutMapping("/member/{id}")
    public void upaMember(@PathVariable("id") UmsMember umsMember){
        userService.updateMember(umsMember);
    }
    //删除会员信息
    @DeleteMapping("/member/{id}")
    public void delMember(@PathVariable("id") String id){
        userService.deleteMember(id);
    }
    //新增会员
    @PostMapping("/member")
    public void insMember(UmsMember umsMember){
        userService.saveMember(umsMember);
    }

    //查询全部会员的地址信息
    @GetMapping("/receiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAllMemberReceiveAddress(){
        List<UmsMemberReceiveAddress> receiveAddress = userService.getAllMemberReceiveAddress();
        return receiveAddress;
    }
    //根据id查询会员地址信息
    @GetMapping("/receiveAddress/{id}")
    @ResponseBody
    public UmsMemberReceiveAddress getMemberReceiveAddressById(@PathVariable("id") String id){
        UmsMemberReceiveAddress receiveAddress = userService.getMemberReceiveAddressById(id);
        return receiveAddress;
    }
    //更新会员信息
    @PutMapping("/receiveAddress/{id}")
    public void upaMemberReceiveAddress(@PathVariable("id") UmsMemberReceiveAddress receiveAddress){
        userService.updateMemberReceiveAddress(receiveAddress);
    }
    //删除会员信息
    @DeleteMapping("/receiveAddress/{id}")
    public void delMemberReceiveAddress(@PathVariable("id") String id){
        userService.deleteMemberReceiveAddress(id);
    }
    //新增会员
    @PostMapping("/receiveAddress")
    public void insMemberReceiveAddress(UmsMemberReceiveAddress receiveAddress){
        userService.saveReceiveAddress(receiveAddress);
    }

}
