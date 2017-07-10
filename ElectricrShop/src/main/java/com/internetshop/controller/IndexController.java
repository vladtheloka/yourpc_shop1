package com.internetshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.internetshop.service.CommodityService;
import com.internetshop.service.MakerService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	@Autowired
	private MakerService makerService;
	@Autowired
	private CommodityService commodityService;

	@GetMapping("/")
	public String index(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("makers", makerService.findAll());
		model.addAttribute("allCommodyties", commodityService.findAllPages(pageable) );

/*		model.addAttribute("computerList", commodityService.findAll());
		model.addAttribute("houseHoldAppliances", householdAppliancesService.findAll());*/
		return "views-base-index";
	}
	@PostMapping("/")
	public String indexAfterLogin(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("allCommodyties", commodityService.findAllPages(pageable) );
		return "views-base-index";
	}


}
