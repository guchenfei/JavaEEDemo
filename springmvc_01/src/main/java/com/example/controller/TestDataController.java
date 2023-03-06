package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestDataController {

    @RequestMapping("/getParam1")
    public String getParam1(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username  " + username + "  password  " + password);
        return "getParamSuccess";
    }

    @RequestMapping("/getParam2")
    public String getParam2(String username,@RequestParam("pwd") int password){
        System.out.println("username  " + username + "  password  " + password);
        return "getParamSuccess";
    }
}
