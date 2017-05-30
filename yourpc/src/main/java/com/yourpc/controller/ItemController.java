package com.yourpc.controller;

import com.yourpc.editors.CategoryEditor;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;
import com.yourpc.service.CategoryService;
import com.yourpc.service.ItemService;
import com.yourpc.validator.item.ItemValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class ItemController
{
    private final ItemService itemService;

    private final CategoryService categoryService;

    @Autowired
    public ItemController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }

    @InitBinder
    public void init(WebDataBinder binder)
    {
        binder.registerCustomEditor(Category.class, new CategoryEditor());
    }

    @GetMapping(value="/item")
    public String addItem(Model model)
    {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", categoryService.getAll());
        return "item";
    }

    @PostMapping(value="/saveItem")
    public String addItem(@ModelAttribute Item item, Model model)
    {
        try
        {
            itemService.add(item);
        }
        catch (Exception e)
        {
            if(e.getMessage().equals(ItemValidationMessages.EMPTY_ITEMNAME_FIELD)
                    || e.getMessage().equals(ItemValidationMessages.ITEMNAME_ALREADY_EXIST))
            {
                model.addAttribute("itemnameException", e.getMessage());
            }
            else if(e.getMessage().equals(ItemValidationMessages.EMPTY_CONTENT_FIELD))
            {
                model.addAttribute("itemcontentException", e.getMessage());
            }
            else if(e.getMessage().equals(ItemValidationMessages.ZERO_PRICE_FIELD))
            {
                model.addAttribute("itempriceException", e.getMessage());
            }
            model.addAttribute("categories", categoryService.getAll());
            return "item";
        }
        return "redirect:/";
    }

    @GetMapping(value="/deleteItem/{id}")
    public String deleteItem(@PathVariable int id)
    {
        itemService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/updateItem/{id}")
    public String getItem(@PathVariable int id, Model model)
    {
        model.addAttribute("itemAttribute", itemService.getOne(id));
        model.addAttribute("categories", categoryService.getAll());
        return "updateItem";
    }

    @PostMapping(value="/updateItem/{id}")
    public  String updateItem(@ModelAttribute Item item, @PathVariable int id, Model model)
    {
        item.setId(id);
        itemService.update(item);
        model.addAttribute("items", itemService.getAll());
        return "redirect:/";
    }
}
