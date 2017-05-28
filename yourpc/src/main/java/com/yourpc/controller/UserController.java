package com.yourpc.controller;

import com.yourpc.editors.RoleEditor;
import com.yourpc.entity.Role;
import com.yourpc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Controller
@Transactional
public class UserController 
{
	private final UserService userService;

	private final RoleService roleService;

	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@InitBinder
	public void init(WebDataBinder binder)
    {
        binder.registerCustomEditor(Role.class, new RoleEditor());
    }

	@GetMapping(value="/signup")
	public String signUp(Model model)
	{
	    model.addAttribute("user", new User());
	    model.addAttribute("roles", roleService.getAll());
		return "signup";
	}
	
	@PostMapping(value="/saveUser")
	public String signUp(@ModelAttribute User user)
	{
		userService.add(user);
		return "redirect:/";
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
        model.addAttribute("roles", roleService.getAll());
		return "updateUser";
	}

	@PostMapping(value="/updateUser/{id}")
	public String updateUser(@ModelAttribute User user, @PathVariable int id, Model model)
	{
		user.setId(id);
		userService.update(user);
		model.addAttribute("users", userService.getAll());
		return "redirect:/";
	}
}
