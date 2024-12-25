package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Student;
import java.util.List;

public interface StudentService {
    Student findStudentById(int id);

    List<Student> findAllStudents();

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(int id);
}
