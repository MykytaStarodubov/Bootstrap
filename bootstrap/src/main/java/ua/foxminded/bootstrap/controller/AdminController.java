package ua.foxminded.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.foxminded.bootstrap.model.User;
import ua.foxminded.bootstrap.model.enummodel.Role;
import ua.foxminded.bootstrap.dao.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String adminPanel(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", Role.values());
        return "admin";
    }

    @PostMapping("/assign-role")
    public String assignRole(@RequestParam Long userId, @RequestParam Role role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        user.setRole(role);
        userRepository.save(user);
        return "redirect:/admin";
    }
}
