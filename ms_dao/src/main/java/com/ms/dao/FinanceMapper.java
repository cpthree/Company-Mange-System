package com.ms.dao;

import com.ms.entity.Finance;
import com.ms.entity.FinanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceMapper {
    int countByExample(FinanceExample example);

    int deleteByExample(FinanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> selectByExample(FinanceExample example);

    Finance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByExample(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}