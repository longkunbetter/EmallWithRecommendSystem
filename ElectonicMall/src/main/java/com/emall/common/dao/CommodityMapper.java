package com.emall.common.dao;

import com.emall.common.entity.Commodity;

import java.util.List;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);

    /**
     * 获取全部商品的id
     * */
    List<String> selectAllIds();

    /**
     * 获取指定一组id的商品数据
     * */
    List<Commodity> selectByIds(List<String> idList);

    /**
     * 获取指定类型的商品数据
     * @param cid
     *          类型id
     * */
    List<Commodity> listByCategorize(int cid);

    /**
     * 根据关键词获取商品
     * @param keywords
     *          关键词
     * */
    List<Commodity> listByKeyword(List<String> keywords);
}