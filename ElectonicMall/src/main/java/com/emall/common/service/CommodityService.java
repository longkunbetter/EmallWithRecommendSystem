package com.emall.common.service;

import com.emall.common.dao.CategorizeMapper;
import com.emall.common.dao.CommodityMapper;
import com.emall.common.entity.Categorize;
import com.emall.common.entity.Commodity;
import com.emall.system.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommodityService {
    @Autowired
    private CategorizeMapper categorizeDao;
    @Autowired
    private CommodityMapper commodityDao;

    /**
     * 获取前n个一级商品分类
     * @param n
     *      前n个
     * @return 前n个顶级分类的对象，若不足n，则数量为顶级分类的总量
     * */
    public List<Categorize> listTopCategorize(int n){
        return categorizeDao.selectByHierarchy(0, n, true);
    }

    /**
     * 根据顶层商品类型ID获取该类型下属所有二级分类
     * @param topCategorizeId
     *          顶层商品ID
     * @return
     *          该商品类型下属所有二级分类
     * */
    public List<Categorize> listCategorizeByTopCategorize(int topCategorizeId){
        return categorizeDao.selectByTopCategorize(topCategorizeId);
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
}
