package com.emall.system.interceptor;

import com.emall.common.constant.EmallConf;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录权限控制，未登录时仅允许用户访问有限的页面
 * */
public class LoginPermissionInterceptor implements HandlerInterceptor{
    private static final Log log = LogFactory.getLog(LoginPermissionInterceptor.class);

    private static final String[] IGNORE_URI_LIST = {
            "/index",
            "/login",
            "/common/user/login",
            "/register",
            "/commodity/",
    };

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getServletPath();
        for (String ignoreUri : IGNORE_URI_LIST){
            if (uri.startsWith(ignoreUri)){
                log.debug(uri + "没有被拦截");
                return true;
            }
        }

        Object loginInfo = httpServletRequest.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        if (loginInfo == null){
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
