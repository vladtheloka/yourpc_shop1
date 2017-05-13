package com.yourpc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

public class WelcomeController extends HttpServlet 
{
	private static final long serialVersionUID = -3554323831708251860L;
	static ConfigurableApplicationContext context = null;

	static 
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserService userService = (UserService) context.getBean("userServiceImpl");
		
		List<User> users = userService.getAll();
		String allUsers = "";
		
		for (User user : users) 
		{
			allUsers += user.toString() + "<br>";
		}
		
		req.setAttribute("allUsers", allUsers);
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);
	}
}
