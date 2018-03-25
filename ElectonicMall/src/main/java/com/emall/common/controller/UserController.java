package com.emall.common.controller;

import com.emall.common.entity.EmallUser;
import com.emall.common.service.EmallUserService;
import com.emall.recomd.UserBehavior;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value= "/common/user")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private EmallUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(EmallUser loginInfo, HttpSession httpSession){
        EmallUser loginedUser = userService.verifyUser(loginInfo);
        if (loginedUser != null){
            httpSession.setAttribute("loginInfo", loginedUser);

            //登录行为记录到日志
            log.info("behavior\t" + + UserBehavior.LOGIN);

            return "redirect:/index";
        }
        else {
            return "login";
        }
    }

    @RequestMapping(value = "loginout", method = RequestMethod.GET)
    public String userLoginOut(HttpSession httpSession){
        httpSession.removeAttribute("loginInfo");
        httpSession.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String userRegister(EmallUser registerInfo){

    }
}
