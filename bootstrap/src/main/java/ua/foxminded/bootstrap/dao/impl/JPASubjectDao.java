package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.SubjectRepository;
import ua.foxminded.bootstrap.model.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPASubjectDao implements SubjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Subject> findById(int id) {
        return Optional.ofNullable(entityManager.find(Subject.class, id));
    }

    @Override
    public List<Subject> findAll() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    @Transactional
    @Override
    public void create(Subject subject) {
        entityManager.persist(subject);
    }

    @Transactional
    @Override
    public void update(Subject subject) {
        entityManager.merge(subject);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.createQuery("DELETE FROM Subject s WHERE s.subjectId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }
}