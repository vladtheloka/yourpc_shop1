package com.internetshop.controller;
import com.internetshop.entity.User;
import com.internetshop.service.MailSenderService;
import com.internetshop.service.UserService;
import com.internetshop.validator.UserValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;
import java.util.UUID;


@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailSenderService mailSenderSe;

    @GetMapping ("/signUp")
    public  String AddAndUpdateUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        return "views-user-signUp";
    }

    @PostMapping ("/signUp")
    public String AddUserForm(@ModelAttribute User user, Model model){
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);

        try {
            userService.save(user);
        } catch (Exception e) {
          if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                  e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXIST)){
              model.addAttribute("usernameException", e.getMessage());
          }else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL)||
                  e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)||
                  e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)){
              model.addAttribute("emailException", e.getMessage());
          }else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD)||
                  e.getMessage().equals(UserValidationMessages.TO_SHORT_PASSWORD)){
              model.addAttribute("passwordException", e.getMessage());
              }
            return "views-user-signUp";
        }
        String theme = "thank's for registration";
        String mailBody = "Good Luck:     http://localhost:8080/confirm/" + uuid;
        mailSenderSe.sendMail(theme, mailBody, user.getEmail());
        return "redirect:/";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUserPage(Model model, @PathVariable int id)
    {
        model.addAttribute("userAttribute", userService.findOne(id));
        return "views-update-updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute ("userAttribute") User user, Model model){
 
			try {
				userService.update(user);
			} catch (Exception e) {
				if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
		                  e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXIST)){
		              model.addAttribute("usernameupdateExeption", e.getMessage());
		          }else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL)||
		                  e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)||
		                  e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)){
		              model.addAttribute("emailupdateException", e.getMessage());
		          }else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD)||
		                  e.getMessage().equals(UserValidationMessages.TO_SHORT_PASSWORD)){
		              model.addAttribute("passwordupdateException", e.getMessage());
		              }
		            return "views-update-updateUser";
			}
		
        return "redirect:/signUp";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userService.delete(id);
        return "redirect:/signUp";

    }
    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) throws Exception {
        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        userService.updateConf(user);

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model)
    {
        model.addAttribute("findUser", new User());

        model.addAttribute("userBasket", userService.userWithCommodyties(Integer.parseInt(principal.getName())));

        return "views-user-profile";
    }
}
