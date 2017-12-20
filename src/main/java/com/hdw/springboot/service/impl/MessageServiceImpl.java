package com.hdw.springboot.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdw.springboot.entity.Message;
import com.hdw.springboot.mapper.MessageMapper;
import com.hdw.springboot.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> list() {
        return messageMapper.list();
    }

    @Override
    public int count() {
        return messageMapper.count();
    }

}