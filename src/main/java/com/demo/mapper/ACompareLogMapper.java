package com.demo.mapper;
import org.apache.ibatis.annotations.Param;

import com.demo.entity.ACompareLog;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lai dian sheng yin b
* @description 针对表【a_compare_log】的数据库操作Mapper
* @createDate 2022-05-27 10:54:33
* @Entity com.demo.entity.ACompareLog
*/
@Mapper
public interface ACompareLogMapper {

    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(ACompareLog record);

    int insertSelective(ACompareLog record);

    ACompareLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ACompareLog record);

    int updateByPrimaryKey(@Param("record") ACompareLog record);


}
