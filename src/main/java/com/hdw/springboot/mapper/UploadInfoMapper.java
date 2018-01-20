package com.hdw.springboot.mapper;


import com.hdw.springboot.entity.UploadInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UploadInfoMapper {
//    @Select("SELECT * FROM uploadInfo")
//    @Results({@Result(property = "nickName", column = "nick_name")
//    })
//    List<UploadInfo> getAll();
//
//    @Select("SELECT * FROM uploadInfo where ID =#{id}")
//    @Results({@Result(property = "nickName", column = "nick_name")
//    })
//    UploadInfo getOne(int id);
//
//
//    @Insert("INSERT INTO uploadInfo(package_name,class_name,method_name,project_id,project_name) VALUES(#{package_name},#{class_name},#{method_name},#{project_id},#{project_name})")
//    void insert(UploadInfo uploadInfo);
//
//    @Select("SELECT * FROM uploadInfo")
//    @Results({@Result(property = "test", column = "test")})
//    List<UploadInfo> findAll();
//
//    @Select("SELECT count(*) FROM uploadInfo")
//    @Results({@Result(property = "test", column = "test")})
      int countItem();
      void insertData(UploadInfo uploadInfo);
      List<UploadInfo> getAll();
      List<UploadInfo>  getItemBySize(int size);
}