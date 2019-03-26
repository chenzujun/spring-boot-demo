/*
 * Copyright (c)
 */
package com.raine.demo.mapper;


import com.raine.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User Mapper
 * 
 * @author chenjun
 * @date 2019-03-26
 */
public interface IUserMapper {

    User getUserById(Long id);

    void save(User user);
}
