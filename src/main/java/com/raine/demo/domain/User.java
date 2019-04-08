package com.raine.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author chenjun
 * @date 2019/3/26
 * @since V1.0
 */
@Data
public class User {

    private Long id;

    private String name;

    private String password;

    private Date creteTime;

    private Date updateTime;

}
