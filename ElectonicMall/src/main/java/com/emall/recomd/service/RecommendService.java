package com.emall.recomd.service;

import java.util.List;

/**
 * 定义推荐系统接口的操作
 * @date 2018-04-05 22:42:45
 * @author longkun
 * */
public interface RecommendService {
    /**
     * 为指定用户推荐N个商品
     * @param uid
     *          用户id
     * @param recommendNum
     *          N
     * @return
     *          推荐的n个商品的id，若数据不足，则数量可能小于n
     * */
    public List<String> recommendItemsForUser(String uid, int recommendNum);

    /**
     * 以给定的商品为主体，通过基于物品相似度的推荐算法为用户推荐N个商品
     * @param cid
     *          主体商品id
     * @param recommendNum
     *          N
     * @return
     *          推荐的n个商品的id，若数据不足，则数量可能小于n
     * */
    public List<String> recommendByItemSimilarity(String cid, int recommendNum);
}
