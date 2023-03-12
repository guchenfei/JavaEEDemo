package com.example.controller;

import com.example.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerDemo1 {

    @RequestMapping("/test1.action")
    public String test1(){
        int i =  1/0;
        return "success.jsp";
    }

    @RequestMapping("/test2.action")
    public String test2(){
        String s = null;
        System.out.println(s.length());
        return "success.jsp";
    }

    /**
     * @RequestBody 针对解析json 字符串
     * @param emp
     * @return
     */
    @ResponseBody
    @RequestMapping("/demo1.action")
    public Emp demo1(@RequestBody(required = false) Emp emp){
        System.out.println(emp);
        return emp;
    }
    /**
     * 内部异常监控比全局的优先级高
     * @return
     */
//    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
//    public ModelAndView handleException(){
//        final ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("fail.jsp");
//        return modelAndView;
//    }
}
