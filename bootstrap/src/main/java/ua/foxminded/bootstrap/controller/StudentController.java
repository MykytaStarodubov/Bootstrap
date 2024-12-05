package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.Student;
import ua.foxminded.bootstrap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public String listStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
}