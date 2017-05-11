package com.yourpc.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

public class Main 
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		userService.add(new User("loka", "vlad@gmail.com", "pass", "Lviv"));
		context.close();
	}
}
