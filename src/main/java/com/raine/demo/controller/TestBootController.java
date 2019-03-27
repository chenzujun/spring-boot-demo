/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.raine.demo.controller;

import com.raine.demo.domain.User;
import com.raine.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static final String PATH_STARTS_PREFIX = "BOOT-INF/classes/static/voice/";
    private final static Pattern PATTERN = Pattern.compile("^BOOT-INF\\/classes\\/static\\/voice\\/(.*\\.mp3)");

    @Autowired
    private IUserService userService;

    @RequestMapping("user")
    public User getUser() {
        User user = userService.getUserById(1L);
        return user;
    }

    @RequestMapping("voice")
    public List<String> getVoice() throws IOException {
        List<String> voiceNameList = new ArrayList<>();
        String path = TestBootController.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        String newPath = path.subSequence(path.indexOf(":") + 1, path.indexOf("!")).toString();

        JarFile localJarFile = new JarFile(new File(newPath));
        Enumeration<JarEntry> entries = localJarFile.entries();
        List<String> list = new LinkedList<>();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            //获取文件路径
            String innerPath = jarEntry.getName();
            if (innerPath.startsWith(PATH_STARTS_PREFIX)) {
                Matcher matcher = PATTERN.matcher(innerPath);
                if (matcher.find()) {

                    list.add(matcher.group(1));
                }
            }
        }
        localJarFile.close();

        voiceNameList.addAll(list);
        return voiceNameList;
    }

    @RequestMapping("voice2")
    public List<String> getVoice2() throws IOException {
        List<String> voiceNameList = new ArrayList<>();
        File file = ResourceUtils.getFile("classpath:static/voice");
        if(file.exists()){
            File[] files = file.listFiles();
            if (files != null){
                for (File child:files){
                    voiceNameList.add(child.getName());
                }
            }
        }
        return voiceNameList;
    }
}
