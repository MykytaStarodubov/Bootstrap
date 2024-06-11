package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.TimetableRepository;
import ua.foxminded.bootstrap.model.Timetable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPATimetableDao implements TimetableRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Timetable> findById(int id) {
        return Optional.ofNullable(entityManager.find(Timetable.class, id));
    }

    @Override
    public List<Timetable> findAll() {
        return entityManager.createQuery("SELECT t FROM Timetable t", Timetable.class).getResultList();
    }

    @Transactional
    @Override
    public void create(Timetable timetable) {
        entityManager.persist(timetable);
    }

    @Transactional
    @Override
    public void update(Timetable timetable) {
        entityManager.merge(timetable);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.createQuery("DELETE FROM Timetable t WHERE t.timetableId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }
}