package com.emall.recomd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class UserBehaviorRecorder {
    /**
     * 名为BehaviorLogger的logger将被输出到kafka中
     * 配置在log4j.xml中
     * */
    private static final Log behaviorLogger = LogFactory.getLog("BehaviorLogger");

    /**
     * 输出登录/注销的行为日志到kafka
     * @param userid
     *        用户id
     * @param type
     *        操作类型 登录/注销
     * */
    public static void putLoginLog(int userid, String type){
        behaviorLogger.info(userid + "\t" + type);
    }
}



