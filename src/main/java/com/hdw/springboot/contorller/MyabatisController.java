package com.hdw.springboot.contorller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hdw.springboot.mapper.MessageMapper;

@Controller
public class MyabatisController {

    @Autowired
    private MessageMapper messageMapper;



}