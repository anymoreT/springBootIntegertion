package com.hdw.springboot.contorller;

import com.github.pagehelper.PageHelper;
import com.hdw.springboot.entity.Message;
import com.hdw.springboot.entity.PageBean;
import com.hdw.springboot.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyabatisController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping("/{currentPage}/{pageSize}")
    public String index(Model model, @PathVariable("currentPage") int currentPage,
                        @PathVariable("pageSize") int pageSize) {

        // 指定当前需要显示的页码（currentPage），页面列表长度（pageSize）
        PageHelper.startPage(currentPage, pageSize);

        model.addAttribute("page", new PageBean<Message>(messageService.list()));
        return "index";
    }

}