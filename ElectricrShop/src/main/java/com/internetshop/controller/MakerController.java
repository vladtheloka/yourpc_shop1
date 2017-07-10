package com.internetshop.controller;

import com.internetshop.editors.CountryEditor;
import com.internetshop.entity.Country;
import com.internetshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.internetshop.entity.Maker;
import com.internetshop.service.MakerService;
import com.internetshop.validator.MakerValidator.MakerValidationMessages;

@Controller
public class MakerController {
	@Autowired
	private MakerService makerService;
	@Autowired
	private CountryService countryService;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor());
	}


	@GetMapping("/maker")
	 public String addMaker(Model model) {
	  model.addAttribute("makers", makerService.findAll());
	  model.addAttribute("countries", countryService.findAll());
	  model.addAttribute("maker", new Maker());
	  return "views-admin-maker";
	  
	 }
	 @PostMapping("/maker")
	 public String addMaker(@ModelAttribute Maker maker, Model model) {
	  try {
	   makerService.save(maker);
	  } catch (Exception e) {
	   if (e.getMessage().equals(MakerValidationMessages.EMPTY_MAKER_NAME) ||
	     e.getMessage().equals(MakerValidationMessages.MAKER_NAME_ALREADY_EXIST)){
	    model.addAttribute("makerException", e.getMessage());
	   }
	   model.addAttribute("countries", countryService.findAll());
	   return "views-admin-maker";
	  }
	  return "redirect:/maker";
	 }

	@GetMapping("/deleteMaker/{id}")
	public String deleteMaker(@PathVariable int id) {
		makerService.delete(id);
		return "redirect:/maker";

	}

}
