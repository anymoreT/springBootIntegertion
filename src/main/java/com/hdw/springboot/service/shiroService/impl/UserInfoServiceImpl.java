package com.hdw.springboot.service.shiroService.impl;

import com.hdw.springboot.config.ShiroConfig;
import com.hdw.springboot.mapper.UserInfoDao;
import com.hdw.springboot.entity.shiro.UserInfo;
import com.hdw.springboot.service.shiroService.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
    @Override
    public UserInfo findByUsername(String username) {
        logger.info("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}