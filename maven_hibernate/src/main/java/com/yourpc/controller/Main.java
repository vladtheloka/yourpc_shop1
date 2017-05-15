package com.yourpc.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yourpc.service.UserService;

public class Main 
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		System.out.println(userService.getAll());
		context.close();
	}
}
