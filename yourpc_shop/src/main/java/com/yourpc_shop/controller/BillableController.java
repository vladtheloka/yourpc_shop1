package com.yourpc_shop.controller;

import com.yourpc_shop.editors.ItemEditor;
import com.yourpc_shop.editors.UserEditor;
import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.entity.Item;
import com.yourpc_shop.entity.User;
import com.yourpc_shop.service.BillableService;
import com.yourpc_shop.service.ItemService;
import com.yourpc_shop.service.UserService;
import com.yourpc_shop.validator.billable.BillableValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class BillableController
{
    private final BillableService billableService;

    private final UserService userService;

    private final ItemService itemService;

    @Autowired
    public BillableController(BillableService billableService, UserService userService, ItemService itemService) {
        this.billableService = billableService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @InitBinder
    public void init(WebDataBinder binder)
    {
        binder.registerCustomEditor(User.class, new UserEditor());
        binder.registerCustomEditor(Item.class, new ItemEditor());
    }

    @GetMapping(value="/billable")
    public String addBillable(Model model)
    {
        model.addAttribute("billable", new Billable());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("items", itemService.getAll());
        return "views-admin-billable";
    }

    @PostMapping(value="/saveBillable")
    public String addBillable(@ModelAttribute Billable billable, Model model)
    {
        try
        {
            billableService.add(billable);
        }
        catch (Exception e)
        {
            if(e.getMessage().equals(BillableValidationMessages.EMPTY_NAME_FIELD)
                    || e.getMessage().equals(BillableValidationMessages.BILLABLENAME_ALREADY_EXIST))
            {
                model.addAttribute("billablenameException", e.getMessage());
            }
            model.addAttribute("users", userService.getAll());
            model.addAttribute("items", itemService.getAll());
            return "views-admin-billable";
        }
        return "redirect:/";
    }

    @GetMapping(value="/deleteBillable/{id}")
    public String deleteBillable(@PathVariable int id)
    {
        billableService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/updateBillable/{id}")
    public String getBillable(@PathVariable int id, Model model)
    {
        model.addAttribute("billableAttribute", billableService.getOne(id));
        Billable billable = billableService.getOne(id);
        Hibernate.initialize(billable.getItem());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("items", itemService.getAll());
        return "views-admin-updateBillable";
    }

    @PostMapping(value="/updateBillable/{id}")
    public String updateBillable(@ModelAttribute Billable billable, @PathVariable int id, Model model)
    {
        billable.setId(id);
        billableService.update(billable);
        model.addAttribute("billables", billableService.getAll());
        return "redirect:/";
    }

    @GetMapping("/billableDetails/{name}")
    public String billableDetails(@PathVariable String name, Model model)
    {
        Billable billable = billableService.findByName(name);
        model.addAttribute("billable", billable);
        Hibernate.initialize(billable.getItem());
        return "views-user-billableDetails";
    }
}
