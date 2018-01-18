package com.hdw.springboot.service.impl;

import com.hdw.springboot.entity.UploadInfo;
//import com.hdw.springboot.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.hdw.springboot.mapper.UploadInfoMapper;

@Service
public class UploadInfoServiceImpl {
    @Autowired
    private UploadInfoMapper uploadInfoMapper;


//    public void updateData(UploadInfo info_json) {
//        uploadInfoMapper.insert(info_json);
//    }
//
//
//    public List<UploadInfo> findItemByPage(int currentPage, int pageSize) {
//        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
//        PageHelper.startPage(currentPage, pageSize);
//        List<UploadInfo> allItems = uploadInfoMapper.findAll();        //全部商品
//        int countNums = uploadInfoMapper.countItem();            //总记录数
//        PageBean<UploadInfo> pageData = new PageBean<UploadInfo>(currentPage, pageSize, countNums);
//        pageData.setItems(allItems);
//        return pageData.getItems();
//    }

    public  List<UploadInfo> getAll() {
        List<UploadInfo> allItems =  uploadInfoMapper.getAll();
        return allItems;

    }


}