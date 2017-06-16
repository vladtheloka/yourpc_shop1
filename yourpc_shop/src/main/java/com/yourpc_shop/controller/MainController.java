package com.yourpc_shop.controller;

import com.yourpc_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class MainController
{
    private final ItemService itemService;

    @Autowired
    public MainController(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.findAllPages(pageable));
        return "views-base-index";
    }

    @PostMapping("/")
    public String indexAfterLogin(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.findAllPages(pageable));
        return "views-base-index";
    }
}