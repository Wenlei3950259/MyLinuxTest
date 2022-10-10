package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.config.util.JWTUtils;
import com.demo.dto.BackstageLoginDTO;
import com.demo.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(value = "menu")
public class MenuController {

    @ApiOperation(value = "后台用户登录", notes = "后台用户登录(不需要mac地址)", httpMethod = "POST")
    @RequestMapping(value = "/zl/user/backstageLogin",method = RequestMethod.POST)
    public Object Login(@RequestBody BackstageLoginDTO backstageLoginDTO) {
        Object o = JSONObject.toJSON(backstageLoginDTO);
        System.out.println("登录成功咯");
        return o;
    }
}
