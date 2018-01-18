package com.hdw.springboot.mapper;

import com.hdw.springboot.entity.Message;
import com.hdw.springboot.entity.UploadInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM message")
    @Results({@Result(property = "nickName", column = "nick_name")
    })
    List<Message> getAll();

    @Select("SELECT * FROM message where ID =#{id}")
    @Results({@Result(property = "nickName", column = "nick_name")
    })
    Message getOne(int id);


    @Insert("INSERT INTO message(id,nick_Name,ip,insert_time) VALUES(#{id},#{nickName},#{ip},#{insertTime})")
    void insert(Message message);

    @Mapper
    interface UploadInfoMapper {
        public List<UploadInfo> getAll();
    }
}