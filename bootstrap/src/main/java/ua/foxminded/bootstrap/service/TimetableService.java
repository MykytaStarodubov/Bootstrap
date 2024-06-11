package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Timetable;
import java.util.List;

public interface TimetableService {
    Timetable findTimetableById(int id);

    List<Timetable> findAllTimetables();

    void createTimetable(Timetable timetable);

    void updateTimetable(Timetable timetable);

    void deleteTimetableById(int id);
}
