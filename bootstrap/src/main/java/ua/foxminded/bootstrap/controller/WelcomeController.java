package ua.foxminded.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	public String welcome(Model model) {
		model.addAttribute("title", "Welcome to the University Schedule Application");
		return "welcome";
	}
}
