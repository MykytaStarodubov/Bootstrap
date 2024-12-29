package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.User;
import ua.foxminded.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";  
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users_create"; 
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) { 
        User user = userService.findUserById(id); 
        model.addAttribute("user", user);
        return "users_edit";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) { 
        user.setUserId(id.intValue()); 
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id); 
        return "redirect:/users";
    }

}
