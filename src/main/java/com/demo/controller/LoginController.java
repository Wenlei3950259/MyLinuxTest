package com.demo.controller;

import com.demo.config.util.JWTUtils;
import com.demo.dto.UserDTO;
import com.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "User")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, String>> Login(UserDTO user) {
        Map<String, String> UserDat = userService.login(user);
        String token = JWTUtils.getToken(UserDat);
        UserDat.put("token", token);
        return new ResponseEntity<>(UserDat, HttpStatus.OK);
    }



}
