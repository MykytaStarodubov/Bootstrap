package ua.foxminded.bootstrap;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.foxminded.bootstrap.dao.AttendanceRepository;
import ua.foxminded.bootstrap.model.Attendance;
import ua.foxminded.bootstrap.service.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AttendanceServiceImplTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks
    private AttendanceServiceImpl attendanceService;

    public AttendanceServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAttendanceById() {
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(1);
        when(attendanceRepository.findById(1)).thenReturn(attendance);
        assertEquals(attendance, attendanceService.findAttendanceById(1));
    }

    @Test
    public void testFindAllAttendances() {
        List<Attendance> attendances = Arrays.asList(new Attendance(), new Attendance());
        when(attendanceRepository.findAll()).thenReturn(attendances);
        assertEquals(2, attendanceService.findAllAttendances().size());
    }

    @Test
    public void testCreateAttendance() {
        Attendance attendance = new Attendance();
        attendanceService.createAttendance(attendance);
        verify(attendanceRepository, times(1)).create(attendance);
    }

    @Test
    public void testUpdateAttendance() {
        Attendance attendance = new Attendance();
        attendanceService.updateAttendance(attendance);
        verify(attendanceRepository, times(1)).update(attendance);
    }

    @Test
    public void testDeleteAttendanceById() {
        attendanceService.deleteAttendanceById(1);
        verify(attendanceRepository, times(1)).deleteById(1);
    }
}
