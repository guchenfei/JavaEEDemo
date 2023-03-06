package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
    @RequestMapping("/testPathVariable/{id}/{name}")
    public String testPathVariable(@PathVariable("id") Integer id, @PathVariable("name") String name){
        System.out.println("testPathVariable id " + id + " name " + name);
        return "first";
    }


}
