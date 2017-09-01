package com.example.demo.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@RestController
public class DemoMsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMsgApplication.class, args);
	}
}
