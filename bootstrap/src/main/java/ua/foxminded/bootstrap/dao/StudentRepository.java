package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);

    List<Student> findAll();

    void create(Student student);

    void update(Student student);

    void deleteById(int id);
}
