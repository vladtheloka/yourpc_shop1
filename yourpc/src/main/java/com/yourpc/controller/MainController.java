package com.yourpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Controller
public class MainController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("users", userService.getAll());
		return "index";
	}
	
	@GetMapping(value="/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{	
		userService.delete(id);	
		return "redirect:/";
	}
	
	@GetMapping(value="/updateUser/{id}")
	public String getUser(@PathVariable int id, Model model)
	{	
		model.addAttribute("userAttribute", userService.getOne(id));
		return "updateUser";
	}
	
	@PostMapping(value="/updateUser/{id}")
	public String updateUser(@ModelAttribute("userAttribute") User user, @PathVariable int id, Model model)
	{	
		user.setId(id);
		userService.update(user);
		model.addAttribute("users", userService.getAll());
		return "index";
	}
}
