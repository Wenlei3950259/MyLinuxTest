package com.demo.mapper;

import com.demo.dto.DoctorDTO;

import java.util.List;

public interface JsonMapper {
    int batchInsert(List<DoctorDTO> personHistoryDOS);

}
