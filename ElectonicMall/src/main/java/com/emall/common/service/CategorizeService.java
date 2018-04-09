package com.emall.common.service;

import com.emall.common.dao.CategorizeMapper;
import com.emall.common.entity.Categorize;
import com.emall.common.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizeService {
    @Autowired
    private CategorizeMapper categorizeDao;

    /**
     * 通过类型id获取类型信息
     * */
    public Categorize getCategorizeInfoById(int id){
        return categorizeDao.selectByPrimaryKey(id);
    }

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
}
