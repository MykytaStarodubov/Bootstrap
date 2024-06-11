package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.StudentRepository;
import ua.foxminded.bootstrap.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAStudentDao implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Transactional
    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.createQuery("DELETE FROM Student s WHERE s.studentId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }
}
