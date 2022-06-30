package com.demo.controller;

//import com.demo.config.util.RedisUtil;

import com.demo.config.redis.RedisUtil;
import com.demo.dto.RestResponseDTO;
import com.demo.dto.TestCrateTableDTO;
import com.demo.service.TestCrateTableService;
import io.swagger.annotations.Api;
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
    @Autowired
    TestCrateTableService testCrateTableService;
    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/money")
    public RestResponseDTO<Integer> Login(@RequestBody TestCrateTableDTO dto) {
        RestResponseDTO<Integer> restResponseDTO = new RestResponseDTO<Integer>();
        redisUtil.set("dajiba", "文雷");
        Object relut = redisUtil.get("name");
        System.out.println(relut);
        int i = testCrateTableService.insertOrUpdate(dto);
        restResponseDTO.setData(i);
        return restResponseDTO;
    }


}
