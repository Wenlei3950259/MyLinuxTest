package com.demo.controller;

import com.demo.dto.FtDTO;
import com.demo.entity.FtEntity;
import com.demo.service.FtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Ft的各种mybatisX测试", description = "测试地址http://192.168.0.1:8080")
public class FtController {
    @Autowired
    FtService ftService;

    @PostMapping("/saveFt")
    @ApiOperation(value = "保存一个LOG实体", httpMethod = "POST")
    public ResponseEntity<FtEntity> save(@ApiParam(value = "ACompareLogDTO") @RequestBody FtDTO ftDTO) {
        int row = ftService.save(ftDTO);
        System.out.println(row);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/del")
    @ApiOperation(value = "保存一个LOG实体", httpMethod = "GET")
    public ResponseEntity<FtEntity> delete(@RequestParam String id) {
        int row = ftService.delete(id);
        System.out.println(row);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
