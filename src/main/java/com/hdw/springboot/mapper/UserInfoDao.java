package com.hdw.springboot.mapper;

import com.hdw.springboot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao{
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}