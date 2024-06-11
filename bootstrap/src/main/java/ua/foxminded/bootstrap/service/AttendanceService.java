package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance findAttendanceById(int id);

    List<Attendance> findAllAttendances();

    void createAttendance(Attendance attendance);

    void updateAttendance(Attendance attendance);

    void deleteAttendanceById(int id);
}
