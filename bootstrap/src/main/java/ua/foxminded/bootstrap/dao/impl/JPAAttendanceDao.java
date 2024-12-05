package ua.foxminded.bootstrap.dao.impl;

import org.springframework.stereotype.Repository;
import ua.foxminded.bootstrap.model.Attendance;
import ua.foxminded.bootstrap.dao.*;
import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class JPAAttendanceDao implements AttendanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Attendance findById(int id) {
        return entityManager.find(Attendance.class, id);
    }

    @Override
    public List<Attendance> findAll() {
        return entityManager.createQuery("SELECT a FROM Attendance a", Attendance.class)
                            .getResultList();
    }

    @Override
    public void create(Attendance attendance) {
        entityManager.persist(attendance);
    }
    
    @Override
    public void update(Attendance attendance) {
    	entityManager.persist(attendance);
    }

    @Override
    public void deleteById(int id) {
        Attendance attendance = findById(id);
        if (attendance != null) {
            entityManager.remove(attendance);
        }
    }
}

