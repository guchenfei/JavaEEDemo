package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.annotation.WebServlet;

@RequestMapping("/msb")
@Controller
public class MyController {
    @RequestMapping({"/firstController.do","/aaa.do"})
    public String firstController(){
        System.out.println("firstController");
        return "first";
    }

    @RequestMapping(value = "/testRequest" , method = RequestMethod.GET)
    public String testRequest(){
        System.out.println("testRequest");
        return "first";
    }

    @RequestMapping(value = "/testRequest2",headers = "Accept-Encoding=gzip")
    public String testRequest2(){
        System.out.println("testRequest2");
        return "first";
    }
}
