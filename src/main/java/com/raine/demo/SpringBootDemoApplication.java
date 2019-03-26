package com.raine.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.raine.demo.mapper")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("spring-boot demo web Started!");

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
