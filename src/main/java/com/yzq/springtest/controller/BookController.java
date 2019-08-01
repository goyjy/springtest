package com.yzq.springtest.controller;

import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.BookService;
import com.yzq.springtest.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class BookController {

    private final String UPLOADED_FOLDER="E:\\springboot文件上传库\\";

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "book")
    @ResponseBody
    public List<User> book(){
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(User.class);;
        /*criteria.add(Restrictions.like("username","%怡%"));*/
        criteria.setFirstResult(2);
        criteria.setMaxResults(4);
        List<User> list = criteria.list();
        return list;
    }

    @RequestMapping("toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("path","/image/"+file.getOriginalFilename());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @RequestMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
