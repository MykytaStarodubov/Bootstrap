package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.exception.UniversityClassNotFoundException;
import ua.foxminded.bootstrap.model.UniversityClass;
import ua.foxminded.bootstrap.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public String listClasses(Model model) {
        List<UniversityClass> classes = classService.findAllClasses();
        model.addAttribute("classes", classes);
        return "classes";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("class", new UniversityClass());
        return "class_create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createClass(@ModelAttribute("class") UniversityClass clazz) {
        classService.createClass(clazz);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable int id, Model model) throws ClassNotFoundException{
        UniversityClass universityClass = classService.findClassById(id);
        model.addAttribute("class", universityClass);
        return "class_create"; 
    }


    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateClass(@PathVariable int id, @ModelAttribute UniversityClass universityClass) {
        universityClass.setClassId(id);
        classService.updateClass(universityClass);
        return "redirect:/classes";
    }


    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteClass(@PathVariable int id) {
        classService.deleteClassById(id);
        return "redirect:/classes";
    }
}
