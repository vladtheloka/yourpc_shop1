package com.internetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.internetshop.entity.Country;
import com.internetshop.service.CountryService;
import com.internetshop.validator.CountryValidator.CountryValidatorMessages;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/addCountry")
	public String addCountry(Model model){
		model.addAttribute("country", new Country());
		model.addAttribute("countries", countryService.findAll());
		return "views-admin-country";
	}
	@PostMapping("/addCountry")
	public String addCountry(@ModelAttribute Country country, Model model,@RequestParam MultipartFile countryImage){
		try {

			countryService.save(country, countryImage);
		} catch (Exception e) {
			if(e.getMessage().equals(CountryValidatorMessages.FILD_NAME_IS_EMPTY) ||
					e.getMessage().equals(CountryValidatorMessages.COUNTRY_ALREADY_EXIST)){
				model.addAttribute("countryException", e.getMessage());
			}
			return "views-admin-country";
		}
		return "redirect:/addCountry";
	}
	
	@GetMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/addCountry";
		
	}


	
	
	
}
