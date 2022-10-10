package com.demo.mapper;

import com.demo.dto.RoleDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDTO record);

    int insertOrUpdate(RoleDTO record);

    int insertOrUpdateSelective(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);

    int updateBatch(List<RoleDTO> list);

    int updateBatchSelective(List<RoleDTO> list);

    int batchInsert(@Param("list") List<RoleDTO> list);
}
