package com.yourpc_shop.controller;

import com.yourpc_shop.entity.Item;
import com.yourpc_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/all")
    public String allItems(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.findAllPages(pageable));
        return "views-base-index";
    }

    @GetMapping("/cpu")
    public String allCpu(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allCpu(pageable));
        return "views-base-index";
    }

    @GetMapping("/gpu")
    public String allGpu(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allGpu(pageable));
        return "views-base-index";
    }

    @GetMapping("/ram")
    public String allRam(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allRam(pageable));
        return "views-base-index";
    }

    @GetMapping("/psu")
    public String allPsu(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allPsu(pageable));
        return "views-base-index";
    }

    @GetMapping("/case")
    public String allCases(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allCase(pageable));
        return "views-base-index";
    }

    @GetMapping("/storage")
    public String allStorages(Model model, @PageableDefault Pageable pageable)
    {
        model.addAttribute("items", itemService.allStorage(pageable));
        return "views-base-index";
    }
}