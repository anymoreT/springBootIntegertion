package com.hdw.springboot.service;

import java.util.List;

import com.hdw.springboot.entity.Message;

public interface IMessageService {

    List<Message> list();

    int count();

}