package com.emall.common.service;

import com.emall.common.dao.CategorizeMapper;
import com.emall.common.dao.CommodityMapper;
import com.emall.common.entity.Categorize;
import com.emall.common.entity.Commodity;
import com.emall.system.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommodityService {
    @Autowired
    private CommodityMapper commodityDao;

    /**
     * 根据id获取商品
     * @param commodityId
     *          商品id
     * */
    public Commodity getCommodityById(int commodityId){
        return commodityDao.selectByPrimaryKey(commodityId);
    }

    /**
     * 获取指定分类的商品数据
     * */
    public List<Commodity> listCommodityByCategorize(Integer categorizeId){
        return commodityDao.listByCategorize(categorizeId);
    }
    /**
     * 随机选取n条商品数据
     * @param selectNum
     *          n
     * @return
     *          选取的商品数据id集合，若数据量不足，则id数量将小于n
     * */
    public List<String> commodityRandomSelect(int selectNum){
        List<String> allCommodityIds = commodityDao.selectAllIds();
        return randomSelect(allCommodityIds, selectNum);
    }

    /**
     * 通过指定的商品id获取商品信息
     * @param id
     *          商品id
     * */
    public Commodity getCommodityById(Integer id){
        return commodityDao.selectByPrimaryKey(id);
    }

    /**
     * 通过给定的商品id集合获取商品数据
     * */
    public List<Commodity> getCommodityDataByIds(List<String> idList){
        return commodityDao.selectByIds(idList);
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

    /**
     * 根据关键词搜索商品
     * @param keyword
     *          关键词
     * */
    public List<Commodity> searchCommodity(String keyword){
        List<String> keywords = Arrays.asList(keyword.split("\\s+"));
        return commodityDao.listByKeyword(keywords);
    }
}
