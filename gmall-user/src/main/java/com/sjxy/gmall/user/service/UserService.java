package com.sjxy.gmall.user.service;

import com.sjxy.gmall.user.bean.UmsMember;
import com.sjxy.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @ClassName UserService
 * @Desciptionn TODO
 * @Author
 * @Date 2019/12/26 22:28
 * @Version 1.0
 **/
public interface UserService {
    List<UmsMember> getAllMember();

    UmsMember getMemberById(String id);

    void updateMember(UmsMember umsMember);

    void deleteMember(String id);

    List<UmsMemberReceiveAddress> getAllMemberReceiveAddress();

    UmsMemberReceiveAddress getMemberReceiveAddressById(String id);

    void updateMemberReceiveAddress(UmsMemberReceiveAddress receiveAddress);

    void saveMember(UmsMember umsMember);

    void deleteMemberReceiveAddress(String id);

    void saveReceiveAddress(UmsMemberReceiveAddress receiveAddress);
}
