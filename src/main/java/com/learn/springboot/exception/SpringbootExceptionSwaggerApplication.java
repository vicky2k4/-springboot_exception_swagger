package com.learn.springboot.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) //for testing without database url
public class SpringbootExceptionSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExceptionSwaggerApplication.class, args);
	}

}
