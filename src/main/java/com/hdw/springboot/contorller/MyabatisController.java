package com.hdw.springboot.contorller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import com.hdw.springboot.entity.Message;
import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;
import com.hdw.springboot.config.MessageConfiguration;

@RestController
public class MyabatisController {
    @Autowired
    private UploadInfoServiceImpl  uploadInfoService;
    Logger logger =  Logger.getLogger(MyabatisController.class);

    @Autowired
    MessageConfiguration messageConfiguration;



   //获取所有数据+++++++++++++++++++++++++++++++++++++++
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
    public List<UploadInfo>  getUpdateloadInfo(@RequestParam int currentPage, @RequestParam int pageSize, Model model){
        logger.info(String.format("获取数据：%d page, %d pagesize",currentPage, pageSize));
        List<UploadInfo> list_info = uploadInfoService.getItemByIndex(currentPage, pageSize);
        return list_info;
    }



    //    //接受json
    @RequestMapping(value="/insertData", method = RequestMethod.POST)
    public void insertData(@RequestBody  UploadInfo uploadInfo){
        messageConfiguration.message();
        messageConfiguration.test_message();
        logger.info("insertData" + uploadInfo.toString());
        uploadInfoService.insertData(uploadInfo);
   }

}