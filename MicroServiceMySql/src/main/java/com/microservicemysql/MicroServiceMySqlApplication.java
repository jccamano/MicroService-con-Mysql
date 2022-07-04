package com.microservicemysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceMySqlApplication.class, args);
	}

}
