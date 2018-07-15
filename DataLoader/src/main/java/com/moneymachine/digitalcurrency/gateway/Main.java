package com.moneymachine.digitalcurrency.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@EnableAutoConfiguration
@Component
@ComponentScan
@SpringBootApplication
public class Main {
	
	private static ApplicationContext ctx;
	public static ApplicationContext getApplicationContext(){
			return ctx;
	}
	
	 public static void main(String[] args){
			ctx = new ClassPathXmlApplicationContext(
    				"Spring-Module.xml");
			
			SpringApplication.run(Main.class, args);
	}
}
