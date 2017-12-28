package com.hdw.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdw.springboot.entity.UploadInfo;

import com.hdw.springboot.mapper.UploadInfoMapper;

@Service
public class UploadInfoServiceImpl  {
    @Autowired
    private UploadInfoMapper uploadInfoMapper;
    public void updateData(UploadInfo info_json){

        uploadInfoMapper.insert(info_json);
    }






}