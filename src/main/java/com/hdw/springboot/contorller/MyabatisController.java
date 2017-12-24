package com.hdw.springboot.contorller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hdw.springboot.mapper.MessageMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.hdw.springboot.entity.Message;

@RestController
public class MyabatisController {

    @Autowired
    private MessageMapper messageMapper;

    @RequestMapping("/data")
    List<Message> getDate(){
            List<Message> messages =  messageMapper.getAll();
            return messages;
    }



}