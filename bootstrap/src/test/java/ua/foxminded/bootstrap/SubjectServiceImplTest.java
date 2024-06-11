package ua.foxminded.bootstrap;

import ua.foxminded.bootstrap.dao.SubjectRepository;
import ua.foxminded.bootstrap.model.Subject;
import ua.foxminded.bootstrap.service.SubjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceImplTest {

	@Mock
	private SubjectRepository subjectRepository;

	@InjectMocks
	private SubjectServiceImpl subjectService;

	@Test
    public void findSubjectById_shouldThrowException_whenSubjectNotFound() {
        when(subjectRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(SubjectServiceImpl.SubjectNotFoundException.class, () -> {
            subjectService.findSubjectById(1);
        });
    }

	@Test
	public void createSubject_shouldSaveSubject() {

		Subject subject = new Subject("Chemistry");

		subjectService.createSubject(subject);

		verify(subjectRepository).create(subject);
	}

	@Test
	public void updateSubject_shouldUpdateExistingSubject() {

		Subject subject = new Subject(1, "Biology");

		subjectService.updateSubject(subject);

		verify(subjectRepository).update(subject);
	}

	@Test
	public void deleteSubjectById_shouldDeleteSubject() {

		int subjectId = 1;

		subjectService.deleteSubjectById(subjectId);

		verify(subjectRepository).deleteById(subjectId);
	}
}
