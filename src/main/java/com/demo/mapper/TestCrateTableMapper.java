package com.demo.mapper;

import com.demo.entity.TestCrateTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestCrateTableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestCrateTable record);

    int insertOrUpdate(TestCrateTable record);

    int insertOrUpdateSelective(TestCrateTable record);

    int insertSelective(TestCrateTable record);

    TestCrateTable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestCrateTable record);

    int updateByPrimaryKey(TestCrateTable record);

    int updateBatch(List<TestCrateTable> list);

    int updateBatchSelective(List<TestCrateTable> list);

    int batchInsert(@Param("list") List<TestCrateTable> list);
}