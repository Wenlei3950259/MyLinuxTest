package com.demo.mapper;

import com.demo.entity.FtEntity;

/**
* @author lai dian sheng yin b
* @description 针对表【ft】的数据库操作Mapper
* @createDate 2022-05-27 13:44:54
* @Entity com.demo.entity.FtEntity
*/
public interface FtEntityMapper {

    int deleteByPrimaryKey(String id);

    int insert(FtEntity record);

    int insertSelective(FtEntity record);

    FtEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FtEntity record);

    int updateByPrimaryKey(FtEntity record);

}
