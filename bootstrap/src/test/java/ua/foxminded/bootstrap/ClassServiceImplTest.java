package ua.foxminded.bootstrap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.bootstrap.dao.ClassRepository;
import ua.foxminded.bootstrap.model.UniversityClass;
import ua.foxminded.bootstrap.service.impl.ClassServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClassServiceImplTest {

	@Mock
	private ClassRepository classRepository;

	@InjectMocks
	private ClassServiceImpl classService;

	@Test
    public void findClassById_shouldThrowException_whenClassNotFound() {
        when(classRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ClassNotFoundException.class, () -> classService.findClassById(1));
    }

	@Test
	public void createClass_shouldSaveClass() {

		UniversityClass newClass = new UniversityClass(3, "Chemistry");

		classService.createClass(newClass);

		verify(classRepository).create(newClass);
	}

	@Test
	public void deleteClassById_shouldDeleteClass() {
		int idToDelete = 1;

		classService.deleteClassById(idToDelete);

		verify(classRepository).deleteById(idToDelete);
	}

}
