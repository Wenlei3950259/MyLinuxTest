package com.demo.util;

import com.demo.dto.TestCrateTableDTO;
import com.demo.entity.TestCrateTable;

public class CopyValueUtil {
    public static TestCrateTable copyTestCrateTableDTOToTestCrateTable(TestCrateTableDTO record) {
        if (record == null) {
            return null;
        }
        TestCrateTable testCrateTable = new TestCrateTable();
        testCrateTable.setId(record.getId());
        testCrateTable.setCreateTime(record.getCreateTime());
        testCrateTable.setDelFlag(record.getDelFlag());
        return testCrateTable;
    }
}
