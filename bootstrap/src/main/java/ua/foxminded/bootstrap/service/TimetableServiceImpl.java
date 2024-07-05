package ua.foxminded.bootstrap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.bootstrap.dao.TimetableRepository;
import ua.foxminded.bootstrap.exception.TimetableNotFoundException;
import ua.foxminded.bootstrap.model.Timetable;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @Override
    public Timetable findTimetableById(int id) {
        return timetableRepository.findById(id)
                .orElseThrow(() -> new TimetableNotFoundException("Timetable not found: " + id));
    }

    @Override
    public List<Timetable> findAllTimetables() {
        return timetableRepository.findAll();
    }

    @Transactional
    @Override
    public void createTimetable(Timetable timetable) {
        timetableRepository.create(timetable);
    }

    @Transactional
    @Override
    public void updateTimetable(Timetable timetable) {
        timetableRepository.update(timetable);
    }

    @Transactional
    @Override
    public void deleteTimetableById(int id) {
        timetableRepository.deleteById(id);
    }
}