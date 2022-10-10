package com.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.demo.dto.DeptDTO;
import com.demo.dto.DoctorDTO;
import com.demo.mapper.DeptMapper;
import com.demo.mapper.JsonMapper;
import com.demo.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jsonServiceImpl implements JsonService {
    @Autowired
    JsonMapper jsonMapper;
    @Autowired
    DeptMapper deptMapper;
    @Override
    public void add() {

        List<DoctorDTO> data = data();
        jsonMapper.batchInsert(data);
    }

    private  List<DoctorDTO> data() {
        List<DoctorDTO> jsonList = JSONArray.parseArray("netWorthTrend", DoctorDTO.class);
        return jsonList;
    }
}
