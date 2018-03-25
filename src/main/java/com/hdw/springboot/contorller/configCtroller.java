package com.hdw.springboot.contorller;

import com.hdw.springboot.entity.UploadInfo;
import com.hdw.springboot.service.impl.UploadInfoServiceImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
