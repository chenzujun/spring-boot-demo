/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.raine.demo.service.impl;

import com.raine.demo.domain.User;
import com.raine.demo.mapper.IUserMapper;
import com.raine.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjun
 * @date 2019/3/26
 * @since V1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
