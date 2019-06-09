package com.yzq.springtest.controller;

import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        List<User> users = userService.findByUsernameLike("伍");
        for(User u:users){
            System.out.println(u);
        }
        return "伍欣怡";
    }

}
