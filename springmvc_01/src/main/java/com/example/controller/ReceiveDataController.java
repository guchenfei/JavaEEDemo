package com.example.controller;

import com.example.pojo.Person;
import com.example.pojo.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ReceiveDataController {
    @RequestMapping("/getDataByPojo")
    public String getDataByPojo(Person person) {
        System.out.println(person);
        return "success";
    }


    @RequestMapping("/demo1")
    public void testDemo1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("forward.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath() + "/redirect.jsp");
    }


    @RequestMapping("/demo2")
    public String testDemo2() {
        //redirect:不可以省略,不可以省略
        return "redirect:/redirect.jsp";
    }

    @RequestMapping("/demo3")
    public View testDemo3(HttpServletRequest request) {
        View view = null;
//        view = new InternalResourceView("/forward.jsp");
        view = new RedirectView(request.getContextPath() + "/redirect.jsp");
        return view;
    }

    @RequestMapping("/demo4")
    public ModelAndView testDemo4(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/redirect.jsp");
//        modelAndView.setView(new InternalResourceView("/forward.jsp"));
//        modelAndView.setViewName("redirect:/redirect.jsp");
        modelAndView.setView(new RedirectView(request.getContextPath() + "/redirect.jsp"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/testAjax")
    public Pet testAjax(Person person){
        System.out.println(person);
        Pet pet = new Pet("Tom","cat");
        return pet;
    }
}
