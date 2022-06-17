package com.demo.mapper;


import com.demo.dto.UserDTO;
import com.demo.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author lai dian sheng yin b
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2022-06-01 15:11:31
 * @Entity demo.entity.User
 */
public interface UserMapper {

    @MapKey("id")
    Map<String, String> findOne(UserDTO user);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}
