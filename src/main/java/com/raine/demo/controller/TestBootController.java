/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.raine.demo.controller;

import com.raine.demo.domain.User;
import com.raine.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author chenjun
 * @date 2019/3/26
 * @since V1.53
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/test/boot")
public class TestBootController {

    @Autowired
    private IUserService userService;

    @RequestMapping("user")
    public User getUser() {
        User user = userService.getUserById(1L);
        return user;
    }
}
