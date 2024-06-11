package ua.foxminded.bootstrap.dao;

import org.springframework.stereotype.Repository;
import ua.foxminded.bootstrap.model.Attendance;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository {

	Attendance findById(int id);

	List<Attendance> findAll();

	void create(Attendance attendance);

	void update(Attendance attendance);

	void deleteById(int id);
}
