package com.emall.recomd.service.impl;

import com.emall.common.service.CommodityService;
import com.emall.recomd.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 随机推荐(无实际推荐效果)
 * */
@Service
public class RandomRecommendService implements RecommendService{
    @Autowired
    private CommodityService commodityService;

    @Override
    public List<String> recommendItemsForUser(String uid, int recommendNum) {
        return commodityService.commodityRandomSelect(recommendNum);
}

    @Override
    public List<String> recommendByItemSimilarity(String cid, int recommendNum) {
        //先随机选取n + 1个，若这n+1个中存在与主体相同的商品则排除掉,否则保留前n个
        List<String> randomItems = commodityService.commodityRandomSelect(recommendNum + 1);

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
}
