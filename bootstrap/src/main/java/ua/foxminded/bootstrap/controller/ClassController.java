package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.Class;
import ua.foxminded.bootstrap.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/classes")
    public String listClasses(Model model) {
        List<Class> classes = classService.findAllClasses();
        model.addAttribute("classes", classes);
        return "classes";
    }
}