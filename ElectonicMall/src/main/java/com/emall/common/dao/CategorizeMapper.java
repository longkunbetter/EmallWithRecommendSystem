package com.emall.common.dao;

import com.emall.common.entity.Categorize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategorizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Categorize record);

    int insertSelective(Categorize record);

    Categorize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Categorize record);

    int updateByPrimaryKey(Categorize record);

    List<Categorize> selectByHierarchy
            (@Param("start")int start, @Param("num") int num, @Param("isTop") boolean isTop);

    List<Categorize> selectByTopCategorize(int topCategorizeId);
}