package com.emall.common.dao;

import com.emall.common.entity.EmallUser;
import com.emall.common.entity.EmallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmallUserMapper {
    int countByExample(EmallUserExample example);

    int deleteByExample(EmallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmallUser record);

    int insertSelective(EmallUser record);

    List<EmallUser> selectByExample(EmallUserExample example);

    EmallUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmallUser record, @Param("example") EmallUserExample example);

    int updateByExample(@Param("record") EmallUser record, @Param("example") EmallUserExample example);

    int updateByPrimaryKeySelective(EmallUser record);

    int updateByPrimaryKey(EmallUser record);

    EmallUser selectByLoginInfo(EmallUser loginInfo);

    Integer countByUserName(String username);
}