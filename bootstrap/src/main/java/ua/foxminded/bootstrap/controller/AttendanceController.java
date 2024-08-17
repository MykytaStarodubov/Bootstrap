package ua.foxminded.bootstrap.controller;

import ua.foxminded.bootstrap.model.Attendance;
import ua.foxminded.bootstrap.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendances")
    public String listAttendances(Model model) {
        System.out.println("Method listAttendances called"); 
        List<Attendance> attendances = attendanceService.findAllAttendances();
        model.addAttribute("attendances", attendances);
        return "attendances";
    }

}

