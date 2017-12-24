package com.hdw.springboot.mapper;

import com.hdw.springboot.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;



public interface MessageMapper {
    @Select("SELECT * FROM message")
    @Results({@Result(property = "nickName", column = "nick_name")
    })
    List<Message> getAll();
}