package com.yourpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;

	@GetMapping(value="/signup")
	public String signup()
	{
		return "signup";
	}
	
	@PostMapping(value="/saveUser")
	public String saveUser(@RequestParam String username,
			@RequestParam String useremail,
			@RequestParam String userpassword, @RequestParam String useraddress)
	{
		User user = new User(username, useremail, userpassword, useraddress);
		userService.add(user);
		return "redirect:/";
	}
}
