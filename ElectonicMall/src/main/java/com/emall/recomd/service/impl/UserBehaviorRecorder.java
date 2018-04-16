package com.emall.recomd.service.impl;

import com.emall.recomd.constant.BehaviorConstant;
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
    public void putLoginLog(int userid, String type){
        behaviorLogger.info(userid + "\t" + type);
    }

    /**
     * 输出添加购物车的行为日志到kafka
     * @param userid
     *        用户id
     * @param cid
     *        商品id
     * */
    public void putAddCartLog(int userid, int cid){
        behaviorLogger.info(userid + "\t" + BehaviorConstant.ADD_CART + "\t" + cid);
    }

    /**
     * 输出购买商品的行为日志到kafka
     * @param userid
     *        用户id
     * @param cid
     *        商品id
     * */
    public void putBuyItemLog(int userid, int cid){
        behaviorLogger.info(userid + "\t" + BehaviorConstant.BUY_ITEM + "\t" + cid);
    }

    /**
     * 输出点击商品详情的行为日志到kafka
     * @param userid
     *        用户id
     * @param cid
     *        商品id
     * */
    public void putClickItemLog(int userid, int cid){
        behaviorLogger.info(userid + "\t" + BehaviorConstant.CLICK_ITEM + "\t" + cid);
    }

    /**
     * 输出浏览某个商品类目的行为日志到kafka
     * @param userid
     *        用户id
     * @param categoryId
     *        分类id
     * */
    public void putBrowserCategoryLog(int userid, int categoryId){
        behaviorLogger.info(userid + "\t" + BehaviorConstant.BROWSER_CATEGORY + "\t" + categoryId);
    }

    /**
     * 输出搜索指定关键词的行为日志到kafka
     * @param userid
     *        用户id
     * @param keyword
     *        关键词
     * */
    public void putSearchKeywordLog(int userid, String keyword){
        behaviorLogger.info(userid + "\t" + BehaviorConstant.SEARCH + "\t" + keyword);
    }

}



