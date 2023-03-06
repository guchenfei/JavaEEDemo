package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String name,String password){
        String view = "";
        User user = userService.findUser(name,password);
        if (null != user){
            view = "success.jsp";
        }else {
            view = "fail.jsp";
        }
        return view;
    }

    @ResponseBody
    @RequestMapping("/findAllUser.do")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

}
