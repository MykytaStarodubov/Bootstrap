package ua.foxminded.bootstrap;

import ua.foxminded.bootstrap.dao.StudentRepository;
import ua.foxminded.bootstrap.model.Student;
import ua.foxminded.bootstrap.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void findStudentById_shouldThrowException_whenStudentNotFound() {
        when(studentRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(StudentServiceImpl.StudentNotFoundException.class, () -> {
            studentService.findStudentById(1);
        });
    }

  

   
    @Test
    public void createStudent_shouldSaveStudent() {
        Student student = new Student(3, "Alice Johnson");

        studentService.createStudent(student);

        verify(studentRepository).create(student);
    }

    @Test
    public void updateStudent_shouldUpdateExistingStudent() {
    	Student student = new Student(1, "John Doe");


        studentService.updateStudent(student);

        verify(studentRepository).update(student);
    }

    @Test
    public void deleteStudentById_shouldDeleteStudent() {
        int idToDelete = 1;

        studentService.deleteStudentById(idToDelete);

        verify(studentRepository).deleteById(idToDelete);
    }
}
