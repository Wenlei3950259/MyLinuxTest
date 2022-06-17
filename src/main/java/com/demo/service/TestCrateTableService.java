package com.demo.service;

import java.util.List;

import com.demo.dto.TestCrateTableDTO;
import com.demo.entity.TestCrateTable;
public interface TestCrateTableService{


    int deleteByPrimaryKey(Long id);

    int insert(TestCrateTable record);

    int insertOrUpdate(TestCrateTableDTO record);

    int insertOrUpdateSelective(TestCrateTable record);

    int insertSelective(TestCrateTable record);

    TestCrateTable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestCrateTable record);

    int updateByPrimaryKey(TestCrateTable record);

    int updateBatch(List<TestCrateTable> list);

    int updateBatchSelective(List<TestCrateTable> list);

    int batchInsert(List<TestCrateTable> list);

}
