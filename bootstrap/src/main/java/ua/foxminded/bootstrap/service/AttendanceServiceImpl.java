package ua.foxminded.bootstrap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.bootstrap.dao.AttendanceRepository;
import ua.foxminded.bootstrap.model.Attendance;

import java.util.List;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance findAttendanceById(int id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public void createAttendance(Attendance attendance) {
        attendanceRepository.create(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendanceRepository.update(attendance);
    }

    @Override
    public void deleteAttendanceById(int id) {
        attendanceRepository.deleteById(id);
    }
}
