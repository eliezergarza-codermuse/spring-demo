package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/**
	Base packages are classified by object and not by type, 
	this is more microservices compatible since resources are 
	self contained and can be added or removed easier.
*/
@ComponentScan(basePackages = { 
	"com.example.springdemo", 
	"com.example.springdemo.user_account",
	"com.example.springdemo.user_message"
})
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
