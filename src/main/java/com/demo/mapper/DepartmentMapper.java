package com.demo.mapper;

import com.demo.dto.DepartmentDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DepartmentDTO record);

    int insertOrUpdate(DepartmentDTO record);

    int insertOrUpdateSelective(DepartmentDTO record);

    int insertSelective(DepartmentDTO record);

    DepartmentDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepartmentDTO record);

    int updateByPrimaryKey(DepartmentDTO record);

    int updateBatch(List<DepartmentDTO> list);

    int updateBatchSelective(List<DepartmentDTO> list);

    int batchInsert(@Param("list") List<DepartmentDTO> list);

    Long findFirstIdByNameOrId(@Param("name")String name,@Param("id")Long id);


}
