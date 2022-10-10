package com.demo.service.impl;

import com.demo.dto.UserDTO;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<Object, Object> login(UserDTO user) {
        Map<Object, Object> one = userMapper.findOne(user);
        return one;
    }
}
