package com.wenz.demo.controller;

import com.wenz.demo.entity.UserBean;
import com.wenz.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wenz~
 */
@Controller
@Slf4j
public class LoginController {
    //将Service注入Web层
    @Resource
    private UserService userService;

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username, String password, Model model){
        UserBean userBean = userService.LoginIn(username, password);
        log.info("name:{}",username);
        log.info("password:{}",password);
        if(userBean!=null){
            return "success";
        }else {
            model.addAttribute("msg", "账号密码错误");
            return "error";
        }
    }
    @RequestMapping("/index.html")
    public String mainPage(){
        return "index";
    }
    @RequestMapping("/signup")
    public String disp(){
        return "signup";
    }

    //实现注册功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String username,String password){
        userService.Insert(username, password);
        return "success";
    }
}


