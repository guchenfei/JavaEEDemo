package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestFul {
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") String id){
        System.out.println("testGet : " + id);
        return "first";
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.POST)
    public String testPost(@PathVariable("id") String id){
        System.out.println("testPost : " + id);
        return "first";
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") String id){
        System.out.println("testPut : " + id);
        return "first";
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") String id){
        System.out.println("testDelete : " + id);
        return "first";
    }
}
