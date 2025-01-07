package ua.foxminded.bootstrap.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.bootstrap.model.Timetable;
import ua.foxminded.bootstrap.service.TimetableService;

@Controller
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping
    public String showAllTimetables(Model model) {
        model.addAttribute("timetables", timetableService.findAllTimetables());
        return "timetable/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createTimetableForm(Model model) {
        model.addAttribute("timetable", new Timetable());
        return "timetable/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createTimetable(@ModelAttribute Timetable timetable) {
        timetableService.createTimetable(timetable);
        return "redirect:/timetables";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editTimetableForm(@PathVariable int id, Model model) {
        model.addAttribute("timetable", timetableService.findTimetableById(id));
        return "timetable/edit";
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateTimetable(@ModelAttribute Timetable timetable) {
        timetableService.updateTimetable(timetable);
        return "redirect:/timetables";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTimetable(@PathVariable int id) {
        timetableService.deleteTimetableById(id);
        return "redirect:/timetables";
    }
}

