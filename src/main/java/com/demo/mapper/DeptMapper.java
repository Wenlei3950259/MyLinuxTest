package com.demo.mapper;

import com.demo.dto.DeptDTO;

import java.util.List;

public interface DeptMapper {
    int batchInsert(List<DeptDTO> personHistoryDOS);

}
