package com.emall.recomd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 定义用户产生的行为
 */
public class UserBehaviorUtil {
    private static final Log BEHAVIOR_LOGGER = LogFactory.getLog("BehaviorLogger");

    /**
     * 登录网站
     * */
    public static final String LOGIN = "login";
    /**
     * 退出登录
     * */
    public static final String LOGIN_OUT = "loginout";

    /**
     * 输出登录/注销的行为日志
     * @param userid
     *        用户id
     * @param type
     *        操作类型 登录/注销
     * */
    public static void putLoginLog(int userid, String type){
        BEHAVIOR_LOGGER.info(userid + "\t" + type);
    }
}
