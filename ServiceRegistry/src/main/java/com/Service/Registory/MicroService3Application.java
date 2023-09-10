package com.Service.Registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer 
public class MicroService3Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService3Application.class, args);
		System.out.println("goooooooooo");
	}

}
