package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.Subject;
import ua.foxminded.bootstrap.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public String listSubjects(Model model) {
        List<Subject> subjects = subjectService.findAllSubjects();
        System.out.println(subjects); 
        model.addAttribute("subjects", subjects);
        return "subjects";  
    }


    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjects";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createSubject(@ModelAttribute Subject subject) {
        subjectService.createSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable int id, Model model) {
        Subject subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjects";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateSubject(@PathVariable int id, @ModelAttribute Subject subject) {
        subject.setSubjectId(id); 
        subjectService.updateSubject(subject);
        return "redirect:/subjects";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSubject(@PathVariable int id) {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
}
