package com.yzq.springtest.controller;

import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="hello/{id}")
    @ResponseBody
    public User hello(@PathVariable int id){
        User user = userService.findOne(id);
        return user;
    }

    @RequestMapping(value="toLogin")
    public String toLogin(Map<String, Object> map){
        User user = new User();
        user.setUsername("");
        map.put("user",user);
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
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

    @RequestMapping(value="login",method = RequestMethod.PUT)
    public String put(){
        return "put方法";
    }

}
