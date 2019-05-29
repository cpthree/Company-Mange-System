package com.ms.dao;

import com.ms.entity.Sendfile;
import com.ms.entity.SendfileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendfileMapper {

    //查询发文管理联合部门表
    List<Sendfile> selectSendfile();

    //old
    int countByExample(SendfileExample example);

    int deleteByExample(SendfileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sendfile record);

    int insertSelective(Sendfile record);

    List<Sendfile> selectByExample(SendfileExample example);

    Sendfile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sendfile record, @Param("example") SendfileExample example);

    int updateByExample(@Param("record") Sendfile record, @Param("example") SendfileExample example);

    int updateByPrimaryKeySelective(Sendfile record);

    int updateByPrimaryKey(Sendfile record);
}