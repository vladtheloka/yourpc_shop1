package com.yourpc_shop.controller;

import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.validator.user.UserValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yourpc_shop.entity.User;
import com.yourpc_shop.service.UserService;

import java.security.Principal;
import java.util.Set;

@Controller
@Transactional
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUp(Model model)
    {
        model.addAttribute("user", new User());
        return "views-user-signUp";
    }

    @PostMapping("/saveUser")
    public String signUp(@ModelAttribute User user, Model model)
    {
        try
        {
            userService.add(user);
        }
        catch (Exception e)
        {
            if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXIST))
            {
                model.addAttribute("usernameException", e.getMessage());
            }
            else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD)||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)||
                    e.getMessage().equals(UserValidationMessages.WRONG_EMAIL))
            {
                model.addAttribute("emailException", e.getMessage());
            }
            else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)||
                    e.getMessage().equals(UserValidationMessages.TOO_SHORT_PASSWORD))
            {
                model.addAttribute("passwordException", e.getMessage());
            }
            else if(e.getMessage().equals(UserValidationMessages.EMPTY_ADDRESS_FIELD))
            {
                model.addAttribute("addressException", e.getMessage());
            }
            return "views-user-signUp";
        }
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id)
    {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, Model model)
    {
        model.addAttribute("userAttribute", userService.getOne(id));
        return "views-admin-updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute("userAttribute") User user, @PathVariable int id)
    {
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model)
    {
        User user = userService.userWithBillables(Integer.parseInt(principal.getName()));
        Set<Billable> billable = user.getBillable();
        for (Billable billable1: billable)
        {
            Hibernate.initialize(billable1.getItem());
        }
        model.addAttribute("user", user);
        return "views-user-profile";
    }
}
