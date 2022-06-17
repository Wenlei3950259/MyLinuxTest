package com.demo.mapper;

import com.demo.entity.HiddenDangerEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HiddenDangerEntityMapper {
    int deleteByPrimaryKey(String region);

    int insert(HiddenDangerEntity record);

    int insertOrUpdate(HiddenDangerEntity record);

    int insertOrUpdateSelective(HiddenDangerEntity record);

    int insertSelective(HiddenDangerEntity record);

    HiddenDangerEntity selectByPrimaryKey(String region);

    int updateByPrimaryKeySelective(HiddenDangerEntity record);

    int updateByPrimaryKey(HiddenDangerEntity record);

    int updateBatch(List<HiddenDangerEntity> list);

    int updateBatchSelective(List<HiddenDangerEntity> list);

    int batchInsert(@Param("list") List<HiddenDangerEntity> list);

    List<HiddenDangerEntity> findByNameAndMobile(@Param("name")String name,@Param("mobile")String mobile);

    

}
