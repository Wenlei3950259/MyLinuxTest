package com.demo.controller;

//import com.demo.config.util.RedisUtil;

import com.demo.config.redis.RedisUtil;
import com.demo.dto.RestResponseDTO;
import com.demo.dto.TestCrateTableDTO;
import com.demo.service.TestCrateTableService;
import com.demo.service.JsonService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (test_crate_table)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/new")
@Api(value = "TestCrateTableController")
public class TestCrateTableController {
    private final static Logger logger = LoggerFactory.getLogger(TestCrateTableController.class);

    @Autowired
    TestCrateTableService testCrateTableService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    JsonService jsonService;

    @PostMapping("/money")
    public RestResponseDTO<Integer> Login(@RequestBody TestCrateTableDTO dto) {
        RestResponseDTO<Integer> restResponseDTO = new RestResponseDTO<Integer>();
        int i = testCrateTableService.insertOrUpdate(dto);
        logger.error("成功条数为->>{}", i);

        restResponseDTO.setData(i);
        return restResponseDTO;
    }
    @PostMapping("/add")
    public void add() {
        jsonService.add();
    }


}
