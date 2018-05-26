package com.hdw.springboot.service.shiroService;


import com.hdw.springboot.entity.shiro.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}