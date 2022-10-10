package com.demo.mapper;

import com.demo.dto.JobDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JobDTO record);

    int insertOrUpdate(JobDTO record);

    int insertOrUpdateSelective(JobDTO record);

    int insertSelective(JobDTO record);

    JobDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JobDTO record);

    int updateByPrimaryKey(JobDTO record);

    int updateBatch(List<JobDTO> list);

    int updateBatchSelective(List<JobDTO> list);

    int batchInsert(@Param("list") List<JobDTO> list);
}
