package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Class;
import java.util.List;

public interface ClassService {
    Class findClassById(int id) throws ClassNotFoundException;

    List<Class> findAllClasses();

    void createClass(Class clazz);

    void updateClass(Class clazz);

    void deleteClassById(int id);
}
