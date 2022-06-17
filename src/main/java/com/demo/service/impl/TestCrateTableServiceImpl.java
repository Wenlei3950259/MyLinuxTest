package com.demo.service.impl;

import com.demo.dto.TestCrateTableDTO;
import com.demo.util.CopyValueUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.demo.entity.TestCrateTable;
import com.demo.mapper.TestCrateTableMapper;
import com.demo.service.TestCrateTableService;
@Service
public class TestCrateTableServiceImpl implements TestCrateTableService{

    @Resource
    private TestCrateTableMapper testCrateTableMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return testCrateTableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TestCrateTable record) {
        return testCrateTableMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(TestCrateTableDTO record) {
        record.setCreateTime(new Date());
        TestCrateTable table = CopyValueUtil.copyTestCrateTableDTOToTestCrateTable(record);
        return testCrateTableMapper.insertOrUpdate(table);
    }

    @Override
    public int insertOrUpdateSelective(TestCrateTable record) {
        return testCrateTableMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(TestCrateTable record) {
        return testCrateTableMapper.insertSelective(record);
    }

    @Override
    public TestCrateTable selectByPrimaryKey(Long id) {
        return testCrateTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TestCrateTable record) {
        return testCrateTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TestCrateTable record) {
        return testCrateTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<TestCrateTable> list) {
        return testCrateTableMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<TestCrateTable> list) {
        return testCrateTableMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<TestCrateTable> list) {
        return testCrateTableMapper.batchInsert(list);
    }

}
