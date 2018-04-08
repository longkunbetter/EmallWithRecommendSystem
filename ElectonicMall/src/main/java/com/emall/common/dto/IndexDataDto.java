package com.emall.common.dto;

import com.emall.common.entity.Commodity;

import java.util.List;

/**
 * 首页商品数据的分类包装
 * */
public class IndexDataDto {
    //首页顶端pannel区展示商品
    private List<Commodity> pannelData;
    //首页猜你喜欢区域展示商品
    private List<Commodity> guessData;
    //首页特性商品区域展示商品
    private List<Commodity> featureData;

    public IndexDataDto(List<Commodity> pannelData, List<Commodity> guessData, List<Commodity> featureData) {
        this.pannelData = pannelData;
        this.guessData = guessData;
        this.featureData = featureData;
    }

    public List<Commodity> getPannelData() {
        return pannelData;
    }

    public List<Commodity> getGuessData() {
        return guessData;
    }

    public List<Commodity> getFeatureData() {
        return featureData;
    }
}
