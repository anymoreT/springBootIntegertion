package com.hdw.springboot.contorller;

import com.alibaba.fastjson.JSONObject;
import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.entity.shiro.UserInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

@Controller
public class configCtroller {
    @Autowired
    private UploadInfoServiceImpl uploadInfoService;
    Logger logger =  Logger.getLogger(MyabatisController.class);

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String  login( @RequestParam("userid") String userId,
                           @RequestParam("password") String password){

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userId, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException uae) {
            logger.info("未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("密码不正确");
        } catch (LockedAccountException lae) {
            logger.info("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("用户名密码次数过多");
        } catch (AuthenticationException ae) {
            logger.info("用户名密码不正确");
        }

        if (subject.isAuthenticated()) {
            logger.info("登录认证通过");
            return "redirect:/welcome";
        } else {
            usernamePasswordToken.clear();
            return "redirct:/login";
        }
    }

    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/ajaxShiroLogin", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxLogin(UserInfo userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }
}
