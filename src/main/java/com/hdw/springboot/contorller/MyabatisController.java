package com.hdw.springboot.contorller;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/data/{id}")
    int getDateById(@PathVariable("id") int id){
        Message message =  messageMapper.getOne(id);
        return message.getId();
    }

    //接受json
    @RequestMapping(value="/inserData", method = RequestMethod.POST)
    public void insertData(@RequestBody  Message message){
        Logger logger =  Logger.getLogger("1");
        logger.info("call insertData method");
        messageMapper.insert(message);
   }


}