package com.yourpc.controller;

import com.yourpc.entity.Role;
import com.yourpc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class RoleController
{
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value="/role")
    public String addRole(Model model)
    {
        model.addAttribute("role", new Role());
        return "role";
    }

    @PostMapping(value="/saveRole")
    public String addRole(@ModelAttribute Role role)
    {
        roleService.add(role);
        return "redirect:/";
    }

    @GetMapping(value="/deleteRole/{id}")
    public String deleteRole(@PathVariable int id)
    {
        roleService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/updateRole/{id}")
    public String getRole(@PathVariable int id, Model model)
    {
        model.addAttribute("roleAttribute", roleService.getOne(id));
        return "updateRole";
    }

    @PostMapping(value="/updateRole/{id}")
    public  String updateRole(@ModelAttribute Role role, @PathVariable int id, Model model)
    {
        role.setId(id);
        roleService.update(role);
        model.addAttribute("roles", roleService.getAll());
        return "redirect:/";
    }
}
