package com.demo.controller;

import com.demo.dto.ACompareLogDTO;
import com.demo.entity.ACompareLog;
import com.demo.service.ACompareLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.GarbageCollectorMXBean;

@RestController
@Api(value = "log的各种mybatisX测试", description = "测试地址http://192.168.0.1:8080")
public class ACompareLogController {
    @Autowired
    ACompareLogService aCompareLogService;

    @PostMapping("/save")
    @ApiOperation(value = "保存一个LOG实体", httpMethod = "POST")
    public ResponseEntity<ACompareLog> save(@ApiParam(value = "ACompareLogDTO") @RequestBody ACompareLogDTO aCompareLogDTO) {
        int row = aCompareLogService.save(aCompareLogDTO);
        System.out.println(row);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
