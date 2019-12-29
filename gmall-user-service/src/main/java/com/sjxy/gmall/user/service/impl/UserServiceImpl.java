package com.sjxy.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sjxy.gmall.bean.UmsMember;
import com.sjxy.gmall.bean.UmsMemberReceiveAddress;
import com.sjxy.gmall.service.UserService;
import com.sjxy.gmall.user.mapper.UmsMemberMapper;
import com.sjxy.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Desciptionn TODO
 * @Author
 * @Date 2019/12/26 22:28
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    UmsMemberReceiveAddressMapper receiveAddressMapper;

    /** 查询全部会员信息 */
    @Override
    public List<UmsMember> getAllMember() {
        List<UmsMember> umsMembers = umsMemberMapper.selectAll();
        return umsMembers;
    }

    /** 根据ID查询会员信息 */
    @Override
    public UmsMember getMemberById(String id) {
        return umsMemberMapper.selectByPrimaryKey(id);
    }

    /** 更新会员信息 */
    @Override
    public void updateMember(UmsMember umsMember) {
        umsMemberMapper.updateByPrimaryKey(umsMember);
    }

    /** 根据ID删除会员信息 */
    @Override
    public void deleteMember(String id) {
        umsMemberMapper.deleteByPrimaryKey(id);
    }
    /** 新增会员信息 */
    @Override
    public void saveMember(UmsMember umsMember) {
        umsMemberMapper.insert(umsMember);
    }
    /** 删除会员地址信息 */
    @Override
    public void deleteMemberReceiveAddress(String id) {
        receiveAddressMapper.deleteByPrimaryKey(id);
    }

    /** 新增会员地址信息 */
    @Override
    public void saveReceiveAddress(UmsMemberReceiveAddress receiveAddress) {
        receiveAddressMapper.insert(receiveAddress);
    }

    /** 查询全部会员地址信息 */
    @Override
    public List<UmsMemberReceiveAddress> getAllMemberReceiveAddress() {
        return receiveAddressMapper.selectAll();
    }

    /** 根据id查询会员地址信息
     * @return*/
    @Override
    public List<UmsMemberReceiveAddress> getMemberReceiveAddressById(String memberId) {
        //return receiveAddressMapper.selectByPrimaryKey(memberId);
        //封装数据对象，通过查询memberReceiveAddress对象得到结果
        UmsMemberReceiveAddress memberReceiveAddress = new UmsMemberReceiveAddress();
        memberReceiveAddress.setMemberId(memberId);
        return receiveAddressMapper.select(memberReceiveAddress);
    }

    /** 更新会员地址信息 */
    @Override
    public void updateMemberReceiveAddress(UmsMemberReceiveAddress receiveAddress) {
        receiveAddressMapper.updateByPrimaryKey(receiveAddress);
    }
}
