package ua.foxminded.bootstrap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.bootstrap.dao.StudentRepository;
import ua.foxminded.bootstrap.exception.StudentNotFoundException;
import ua.foxminded.bootstrap.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found: " + id));
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public void createStudent(Student student) {
        studentRepository.create(student);
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Transactional
    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}