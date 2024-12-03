package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.UniversityClass;
import java.util.List;

public interface ClassService {
    UniversityClass findClassById(int id) throws ClassNotFoundException;

    List<UniversityClass> findAllClasses();

    void createClass(UniversityClass clazz);

    void updateClass(UniversityClass clazz);

    void deleteClassById(int id);
}
