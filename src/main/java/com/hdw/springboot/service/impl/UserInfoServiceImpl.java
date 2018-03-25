package com.hdw.springboot.service.impl;

import com.hdw.springboot.mapper.UserInfoDao;
import com.hdw.springboot.entity.UserInfo;
import com.hdw.springboot.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}