package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Attendance;

import java.util.List;

public interface AttendanceRepository {

    Attendance findById(int id);

    List<Attendance> findAll();

    void create(Attendance attendance);

    void update(Attendance attendance);

    void deleteById(int id);
}
