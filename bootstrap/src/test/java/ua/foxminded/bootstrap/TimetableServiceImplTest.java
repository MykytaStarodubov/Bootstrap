package ua.foxminded.bootstrap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.bootstrap.dao.TimetableRepository;
import ua.foxminded.bootstrap.exception.TimetableNotFoundException;
import ua.foxminded.bootstrap.model.Timetable;
import ua.foxminded.bootstrap.service.TimetableServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TimetableServiceImplTest {

    @Mock
    private TimetableRepository timetableRepository;

    @InjectMocks
    private TimetableServiceImpl timetableService;

    @Test
    public void findTimetableById_shouldThrowException_whenTimetableNotFound() {
        when(timetableRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(TimetableNotFoundException.class, () -> timetableService.findTimetableById(1));
    }

    @Test
    public void createTimetable_shouldSaveTimetable() {
        Timetable timetable = new Timetable(1, "Description", "Wednesday", "2:00 PM - 3:30 PM");

        timetableService.createTimetable(timetable);

        verify(timetableRepository).create(timetable);
    }

    @Test
    public void updateTimetable_shouldUpdateExistingTimetable() {
        Timetable timetable = new Timetable(1, "Description", "Wednesday", "2:00 PM - 3:30 PM");

        timetableService.updateTimetable(timetable);

        verify(timetableRepository).update(timetable);
    }

    @Test
    public void deleteTimetableById_shouldDeleteTimetable() {
        int idToDelete = 1;

        timetableService.deleteTimetableById(idToDelete);

        verify(timetableRepository).deleteById(idToDelete);
    }
}
