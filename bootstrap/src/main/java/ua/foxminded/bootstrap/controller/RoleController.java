package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.Role;
import ua.foxminded.bootstrap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public String listRoles(Model model) {
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        return "roles";
    }
}