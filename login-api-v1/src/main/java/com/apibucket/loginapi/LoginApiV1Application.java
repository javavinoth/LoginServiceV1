package com.apibucket.loginapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LoginApiV1Application {

	public static void main(String[] args) {
		SpringApplication.run(LoginApiV1Application.class, args);
	}
}
