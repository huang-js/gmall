package com.sjxy.gmall.user.service.impl;

import com.sjxy.gmall.bean.UmsMember;
import com.sjxy.gmall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;



@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void getAllMember() {
        List<UmsMember> umsMemberList = userService.getAllMember();
        for (UmsMember umsMember:umsMemberList){
            System.out.println(umsMember);
        }
    }

    @Test
    void getMemberById() {
        UmsMember umsMember = userService.getMemberById("1");
        System.out.println(umsMember);
    }

    @Test
    void updateMember() {
        /*id=1, memberLevelId=4, username=test, password=202cb962ac59075b964b07152d234b70, nickname=windir, phone=18061581849,
        status=1, createTime=Thu Aug 02 10:35:44 CST 2018, icon=null, gender=1, birthday=Mon Jun 01 00:00:00 CST 2009, city=上海,
        job=学生, personalizedSignature=test, sourceType=null, integration=5000, growth=null, luckeyCount=null, historyIntegration=null)
        */

        UmsMember umsMember = new UmsMember();
        umsMember.setMemberLevelId("4");
        umsMember.setUsername("laohuang");
        umsMember.setPassword(UUID.randomUUID().toString());
        umsMember.setNickname("laohuang");
        umsMember.setPhone("15656456456");
        umsMember.setStatus(1);
        umsMember.setCreateTime(new Date());
        umsMember.setJob("学生");
        umsMember.setCity("南京");
        umsMember.setBirthday(new Date());
        userService.updateMember(umsMember);

    }

    @Test
    void deleteMember() {
        userService.deleteMember("13");
    }

    @Test
    void save() {
        UmsMember umsMember = new UmsMember();
        umsMember.setMemberLevelId("4");
        umsMember.setUsername("laohuang1");
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        umsMember.setPassword(uuid);
        umsMember.setNickname("laohuang");
        umsMember.setPhone("1565456456");
        umsMember.setStatus(1);
        umsMember.setCreateTime(new Date());
        umsMember.setJob("学生");
        umsMember.setCity("南京");
        umsMember.setBirthday(new Date());
        userService.saveMember(umsMember);
    }



}