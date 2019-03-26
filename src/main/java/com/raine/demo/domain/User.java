/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.raine.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author chenjun
 * @date 2019/3/26
 * @since V1.53
 */
@Data
public class User {

    private Long id;

    private String name;

    private String password;

    private Date creteTime;

    private Date updateTime;

}
