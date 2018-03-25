package com.hdw.springboot.service;


import com.hdw.springboot.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}