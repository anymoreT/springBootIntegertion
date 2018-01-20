package com.hdw.springboot.contorller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.hdw.springboot.mapper.MessageMapper;
import java.util.List;
import com.hdw.springboot.entity.Message;
import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;

@RestController
public class MyabatisController {

//    @Autowired
//    private MessageMapper messageMapper;
    @Autowired
    private UploadInfoServiceImpl  uploadInfoService;
    Logger logger =  Logger.getLogger(MyabatisController.class);
//
//    @RequestMapping("/data")
//    List<Message> getDate(){
//            List<Message> messages =  messageMapper.getAll();
//            return messages;
//    }
//
//    @RequestMapping("/data/{id}")
//    int getDateById(@PathVariable("id") int id){
//        Message message =  messageMapper.getOne(id);
//        return message.getId();
//    }
//
//    //接受json
//    @RequestMapping(value="/inserData", method = RequestMethod.POST)
//    public void insertData(@RequestBody  Message message){
//
//        logger.info("call insertData method");
//        messageMapper.insert(message);
//   }

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

    /*
    获取指定的数据条数
*/
    @RequestMapping(value="getItemBySize", method = RequestMethod.GET)
    public @ResponseBody List<UploadInfo> getItemBySize(@RequestParam("size") int size){
        List<UploadInfo>  uploadInfo_list = uploadInfoService.getItemBySize(size);
        return uploadInfo_list;
    }

    /*
    获取数据通过页数
  */
    @RequestMapping(value="getItemByIndex")
    public @ResponseBody List<UploadInfo> getUpdateloadInfo(@RequestParam int currentPage, @RequestParam int pageSize){
        logger.info(String.format("获取数据：%d page, %d pagesize",currentPage, pageSize));
        List<UploadInfo> list_info = uploadInfoService.getItemByIndex(currentPage, pageSize);
        return list_info;
    }

    //    //接受json
    @RequestMapping(value="/insertData", method = RequestMethod.POST)
    public void insertData(@RequestBody  UploadInfo uploadInfo){

        logger.info("insertData" + uploadInfo.toString());
        uploadInfoService.insertData(uploadInfo);
   }

}