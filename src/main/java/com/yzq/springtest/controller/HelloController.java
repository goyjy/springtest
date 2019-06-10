package com.yzq.springtest.controller;

import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello")
    public String hello(Map<String, Object> map){
        User user = userService.findOne(1);
        map.put("user",user);
        System.out.println(user);
        return "index";
    }

    @RequestMapping(value="toLogin")
    public String toLogin(Map<String, Object> map){
        User user = new User();
        user.setUsername("");
        map.put("user",user);
        return "login";
    }

    @RequestMapping(value="login")
    public String login(Map<String, Object> map,User user){
        User u = userService.findByUsername(user.getUsername());
        if (u != null) {
            if(u.getPassword().equals(user.getPassword())){
                map.put("user",u);
                return "index";
            }
        }
        map.put("error","登录失败");
        return "login";
    }

}
