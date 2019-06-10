package com.yzq.springtest.controller;

import com.yzq.springtest.entity.Book;
import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.BookService;
import com.yzq.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "book")
    @ResponseBody
    public String book(){
        User user = userService.findOne(2);
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setName("舞蹈");
        book1.setDate(new Date());
        book1.setUser(user);
        book2.setName("艺术表演");
        book2.setDate(new Date());
        book2.setUser(user);
        user.getBooks().add(book1);
        user.getBooks().add(book2);
        userService.update(user);
        return "伍欣怡";
    }
}
