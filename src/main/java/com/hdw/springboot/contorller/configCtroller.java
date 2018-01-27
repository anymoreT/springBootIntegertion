package com.hdw.springboot.contorller;

import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class configCtroller {
    @Autowired
    private UploadInfoServiceImpl uploadInfoService;
    Logger logger =  Logger.getLogger(MyabatisController.class);

    @RequestMapping(value="testHtml")
    public String  testHtml( Model model){
        logger.info(String.format("获取数据：%d page, %d pagesize",1, 2));
        List<UploadInfo> list_info = uploadInfoService.getItemByIndex(1, 2);
        model.addAttribute("person", list_info);
        return "hello";
    }
}
