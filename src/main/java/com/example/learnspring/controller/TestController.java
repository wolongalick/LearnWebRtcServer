package com.example.learnspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    // 通过 http://127.0.0.1:8081/index 访问
    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }

    // 通过 http://127.0.0.1:8081/ 访问
    @RequestMapping("/showIndex")
    public ModelAndView indexTwo() {
        return new ModelAndView("index");
    }
}