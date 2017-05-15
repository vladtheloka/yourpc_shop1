package com.yourpc.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yourpc.service.BillableService;
import com.yourpc.service.ItemService;
import com.yourpc.serviceimpl.BillableServiceImpl;

public class Main 
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemService itemService = (ItemService) context.getBean("itemServiceImpl");
		BillableService billableService = (BillableService) context.getBean("billableServiceImpl");
		System.out.println(billableService.getBillablewithItems(1));
		context.close();
	}
}
