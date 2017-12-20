package com.hdw.springboot.mapper;
import com.hdw.springboot.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageAnnotationMapper {

    @Select("SELECT NICK_NAME FROM custom")
    @Results({
            @Result(property = "nickName",  column = "NICK_NAME")
    })
    List<Message> list();
}