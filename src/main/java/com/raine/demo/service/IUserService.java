/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.raine.demo.service;

import com.raine.demo.domain.User;

/**
 * @author chenjun
 * @date 2019/3/26
 * @since V1.53
 */
public interface IUserService {

    User getUserById(Long id);

    void save(User user);
}
