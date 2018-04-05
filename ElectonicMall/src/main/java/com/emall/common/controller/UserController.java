package com.emall.common.controller;

import com.emall.common.constant.EmallConf;
import com.emall.common.entity.EmallUser;
import com.emall.common.service.EmallUserService;
import com.emall.recomd.constant.BehaviorConstant;
import com.emall.recomd.service.impl.UserBehaviorRecorder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value= "/common/user")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private EmallUserService userService;

    @Autowired
    private UserBehaviorRecorder userBehaviorRecorder;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(EmallUser loginInfo, HttpSession httpSession){
        EmallUser loginedUser = userService.verifyUser(loginInfo);
        if (loginedUser != null){
            httpSession.setAttribute(EmallConf.LOGIN_INFO_KEY, loginedUser);

            //登录行为记录到日志
            userBehaviorRecorder.putLoginLog(loginedUser.getId(), BehaviorConstant.LOGIN);

            return "redirect:/index";
        }
        else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "loginout", method = RequestMethod.GET)
    public String userLoginOut(HttpSession httpSession){
        //行为日志记录
        EmallUser user = (EmallUser) httpSession.getAttribute("loginInfo");
        userBehaviorRecorder.putLoginLog(user.getId(), BehaviorConstant.LOGIN_OUT);

        httpSession.removeAttribute(EmallConf.LOGIN_INFO_KEY);
        httpSession.invalidate();

        return "redirect:/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String userRegister(EmallUser registerInfo, HttpSession httpSession){
        if (!verifyRegisterInfo(registerInfo)){
            return "redirect:/register";
        }
        //保留原始密码，add后密码会变成加密后的格式
        String originPwd = registerInfo.getPassword();

        boolean res = userService.addUser(registerInfo);
        registerInfo.setPassword(originPwd);

        if (res){
            //注册成功后自动登录
            return this.userLogin(registerInfo, httpSession);
        }
        return "redirect:/register";
    }

    private boolean verifyRegisterInfo(EmallUser registerInfo){
        if (StringUtils.isEmpty(registerInfo.getUsername())
          ||StringUtils.isEmpty(registerInfo.getPassword()))
            return false;
        if (userService.userExist(registerInfo)){
            return false;
        }
        return true;
    }
}
