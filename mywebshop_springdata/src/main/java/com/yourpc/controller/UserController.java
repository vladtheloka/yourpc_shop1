package com.yourpc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

public class UserController extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		User user = new User();
		
		user.setName(req.getParameter("username"));
		user.setEmail(req.getParameter("useremail"));
		user.setPassword(req.getParameter("userpassword"));
		user.setAddress(req.getParameter("useraddress"));
		
//		UserService userService = (UserService) WelcomeController.context.getBean("userServiceImpl");
//		userService.add(user);
	    req.getRequestDispatcher("welcome.jsp").forward(req, resp);
	}
}
