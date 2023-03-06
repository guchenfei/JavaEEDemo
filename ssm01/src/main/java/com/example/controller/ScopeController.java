package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ScopeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/setData")
    public String setData(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        final List<User> allUser = userService.findAllUser();
        final ServletContext application = request.getServletContext();
        request.setAttribute("message","reqMessage");
        request.setAttribute("users",allUser);

        session.setAttribute("message","sessionMessage");
        session.setAttribute("users",allUser);

        application.setAttribute("message","applicationMessage");
        application.setAttribute("users",allUser);
        return "/showDataPage.jsp";
    }


    @RequestMapping("/setData2")
    public String setData2(Model model) {
        final List<User> allUser = userService.findAllUser();
        model.addAttribute("message","reqMessage");
        model.addAttribute("users",allUser);
        //重定向不能以域中参数形式传输,只能以请求参数形式带,但是也是只限于字符串
        return "redirect:/showDataPage.jsp";
    }

    @RequestMapping("/setData3")
    public ModelAndView setData3() {
        final List<User> allUser = userService.findAllUser();
        final ModelAndView modelAndView = new ModelAndView();
        final Map<String, Object> model = modelAndView.getModel();
        model.put("message","reqMessage");
        model.put("users",allUser);
       modelAndView.setViewName("redirect:/showDataPage.jsp");
       return modelAndView;
    }
}
