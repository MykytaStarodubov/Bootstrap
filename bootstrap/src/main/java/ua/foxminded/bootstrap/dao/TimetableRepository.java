package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Timetable;
import java.util.List;
import java.util.Optional;

public interface TimetableRepository {
    Optional<Timetable> findById(int id);

    List<Timetable> findAll();

    void create(Timetable timetable);

    void update(Timetable timetable);

    void deleteById(int id);
}
