package com.hdw.springboot.mapper;

import com.hdw.springboot.entity.Message;
import com.hdw.springboot.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageMapper extends MyMapper<Message> {
    List<Message> list();
    int count();
}