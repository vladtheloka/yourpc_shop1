package com.yourpc.controller;

import com.yourpc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Transactional
public class MainController 
{
	private final UserService userService;

	private final RoleService roleService;

	private final CategoryService categoryService;

	private final ItemService itemService;

	private final BillableService billableService;

	@Autowired
	public MainController(UserService userService, RoleService roleService, CategoryService categoryService, ItemService itemService, BillableService billableService) {
		this.userService = userService;
		this.roleService = roleService;
		this.categoryService = categoryService;
		this.itemService = itemService;
		this.billableService = billableService;
	}

	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("users", userService.getAll());
        model.addAttribute("roles", roleService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("items", itemService.getAll());
        model.addAttribute("billables", billableService.getBillableWithItems());
		return "index";
	}
}
