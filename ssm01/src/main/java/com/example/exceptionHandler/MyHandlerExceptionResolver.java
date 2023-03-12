package com.example.exceptionHandler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        final ModelAndView modelAndView = new ModelAndView();
        if (e instanceof NullPointerException){
            modelAndView.setViewName("fail.jsp");
        }

        if (e instanceof ArithmeticException){
            modelAndView.setViewName("error.jsp");
        }

        modelAndView.addObject("msg",e);
        return modelAndView;
    }
}
