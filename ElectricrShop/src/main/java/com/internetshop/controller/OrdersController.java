package com.internetshop.controller;

import com.internetshop.entity.Orders;
import com.internetshop.service.CommodityService;
import com.internetshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class OrdersController {
@Autowired
private OrdersService ordersService;
@Autowired
private  CommodityService commodityService;

@GetMapping("/addOrder")
public String addCountry(Model model){
	model.addAttribute("ordersList", ordersService.findAll());
	return "views-admin-orders";
}
@PostMapping("/addOrder")
public String addCountry(@RequestParam LocalDateTime OrderDate){
	ordersService.save(new Orders(OrderDate));
	return "redirect:/addOrder";
}

@GetMapping("/deleteOrder/{id}")
public String deleteCountry(@PathVariable int id){
	ordersService.delete(id);
	return "redirect:/addOrder";
	
}
	@GetMapping("/addtobasket/{comID}")
	public String addToBasketComputerCommodities(Principal principal, @PathVariable int comID){
	ordersService.addtobacket(principal, comID);
	return "redirect:/";
}



	@PostMapping ("/buy")
	public String buyCommodity(Principal principal){
		ordersService.buy(Integer.parseInt(principal.getName()));
		return "redirect:/";
	}


	@GetMapping("/deleteFromBasket/{userId}/{comId}")
	public  String deleteComCommodityFromBusket(@PathVariable int userId, @PathVariable int comId){
		commodityService.deleteFromBucket(userId,comId);
		return "redirect:/profile";
	}
	
	
	
}
