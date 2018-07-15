package com.moneymachine.spring.objectpersistanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@Component
@ComponentScan
public class Main {
	 public static void main(String[] args){
		//ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		//Main mainObj = ctx.getBean(Main.class);
		//mainObj.init();
		//HelloWorld obj = (HelloWorld) ctx.getBean("helloBean");
		//obj.printHello();
		 
			ApplicationContext context = new ClassPathXmlApplicationContext(
    				"Spring-Module.xml");
      		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
    		obj.printHello();
		 
	}
}
