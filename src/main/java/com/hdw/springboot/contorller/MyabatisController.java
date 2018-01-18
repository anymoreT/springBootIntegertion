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
import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;

@RestController
public class MyabatisController {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UploadInfoServiceImpl  uploadInfoService;
    Logger logger =  Logger.getLogger("1");

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

        logger.info("call insertData method");
        messageMapper.insert(message);
   }

//   /*
//     保存被修改的方法
//    */
//   @RequestMapping(value="updaloadMethodInfo", method = RequestMethod.POST)
//   public @ResponseBody UploadInfo updataMethodInfo(@RequestBody UploadInfo updateinfo_json){
//       logger.info("接收到json数据"+updateinfo_json.toString());
//       uploadInfoService.updateData(updateinfo_json);
//       return updateinfo_json;
//   }

    /*
   获取所有数据
  */
    @RequestMapping(value="getAll", method = RequestMethod.GET)
    public @ResponseBody List<UploadInfo> getAll(){
        List<UploadInfo>  uploadInfo_list = uploadInfoService.getAll();
        return uploadInfo_list;
    }

//    /*
//    获取数据通过页数
//  */
//    @RequestMapping(value="getUpdateloadInfo", method = RequestMethod.POST)
//    public @ResponseBody List<UploadInfo> getUpdateloadInfo(int currentPage, int pageSize){
//        logger.info("接收到获取数数据");
//        List<UploadInfo> list_info = uploadInfoService.findItemByPage(currentPage, pageSize);
//        return list_info;
//    }


}