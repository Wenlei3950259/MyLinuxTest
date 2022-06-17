package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, String> login(UserDTO user);

}
