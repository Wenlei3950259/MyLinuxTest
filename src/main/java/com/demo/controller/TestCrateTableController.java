package com.demo.controller;

import com.demo.dto.RestResponseDTO;
import com.demo.dto.TestCrateTableDTO;
import com.demo.service.TestCrateTableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * (test_crate_table)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/new")
@Api(value = "TestCrateTableController")
public class TestCrateTableController {
    @Autowired
    TestCrateTableService testCrateTableService;

    @PostMapping("/money")
    public RestResponseDTO<Integer> Login(@RequestBody TestCrateTableDTO dto) {
        RestResponseDTO<Integer> restResponseDTO = new RestResponseDTO<Integer>();
        int i = testCrateTableService.insertOrUpdate(dto);
        restResponseDTO.setData(i);
        return restResponseDTO;
    }


}
