package com.emall.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PageController {
    @RequestMapping(value = "index")
    public String generateUserIndex(){
        return "index";
    }

    @RequestMapping(value = "checkout")
    public String generateCheckOutPage(){
        return "checkout";
    }

    @RequestMapping(value = "register")
    public String generateRegisterPage(){
        return "register";
    }

    @RequestMapping(value = "login")
    public String generateLoginPage(){
        return "login";
    }
}
