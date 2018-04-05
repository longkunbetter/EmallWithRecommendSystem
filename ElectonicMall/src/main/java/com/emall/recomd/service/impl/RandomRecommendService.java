package com.emall.recomd.service.impl;

import com.emall.common.dao.CommodityMapper;
import com.emall.recomd.service.RecommendService;
import com.emall.system.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 随机推荐(无实际推荐效果)
 * */
@Service
public class RandomRecommendService implements RecommendService{
    @Autowired
    private CommodityMapper commodityDao;

    @Override
    public List<String> recommendByCollaborative(String uid, int recommendNum) {
        List<String> allCommodityIds = commodityDao.selectAllIds();
        return randomSelect(allCommodityIds, recommendNum);
    }

    @Override
    public List<String> recommendByItemSimilarity(String cid, int recommendNum) {
        List<String> allCommodityIds = commodityDao.selectAllIds();
        //先随机选取n + 1个，若这n+1个中存在与主体相同的商品则排除掉,否则保留前n个
        List<String> randomItems = randomSelect(allCommodityIds, recommendNum + 1);

        int size = randomItems.size();
        int removeIndex = size - 1;
        for (int i=0; i<size; i++){
            if (cid.equals(randomItems.get(i))){
                removeIndex = i;
            }
        }
        randomItems.remove(removeIndex);

        return randomItems;
    }

    @Override
    public List<String> recommendByUserSimilarity(String uid, int recommendNum) {
        List<String> allCommodityIds = commodityDao.selectAllIds();
        return randomSelect(allCommodityIds, recommendNum);
    }

    /**
     * 从给定的list中随机抽取n条记录
     * @param allRecords
     *          候选集
     * @param selectNum
     *          抽取数量
     * */
    private List<String> randomSelect(List<String> allRecords, int selectNum){
        //如果候选集数量不足n则直接返回原集合
        if (allRecords.size() < selectNum){
            return allRecords;
        }

        int selectRange = allRecords.size();
        //存放选取结果
        List<String> selectResult = new ArrayList<>(selectNum);
        //将已选取的记录的下标放入set，防止重复选取
        Set<Integer> hasSelectSet = new HashSet<>(selectNum * 3);
        while (selectResult.size() < selectNum){
            Integer currentIndex = MathUtil.getRandomInteger(selectRange);
            if (hasSelectSet.contains(currentIndex)){
                continue;
            }
            selectResult.add(allRecords.get(currentIndex));
            hasSelectSet.add(currentIndex);
        }
        return selectResult;
    }
}
