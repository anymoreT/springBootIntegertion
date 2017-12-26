package com.hdw.springboot.mapper;

import com.hdw.springboot.entity.Message;
import com.hdw.springboot.entity.UploadInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface uploadInfoMapper {
    @Select("SELECT * FROM uploadInfo")
    @Results({@Result(property = "nickName", column = "nick_name")
    })
    List<Message> getAll();

    @Select("SELECT * FROM uploadInfo where ID =#{id}")
    @Results({@Result(property = "nickName", column = "nick_name")
    })
    Message getOne(int id);


    @Insert("INSERT INTO uploadInfo(package,class,method,project_id,project_name) VALUES(#{package},#{class},#{method},#{project_id},#{project_name})")
    void insert(UploadInfo uploadInfo);
}