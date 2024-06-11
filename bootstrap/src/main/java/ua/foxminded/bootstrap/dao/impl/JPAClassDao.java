package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.ClassRepository;
import ua.foxminded.bootstrap.model.Class;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAClassDao implements ClassRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Class> findById(int id) {
        return Optional.ofNullable(entityManager.find(Class.class, id));
    }

    @Override
    public List<Class> findAll() {
        return entityManager.createQuery("SELECT c FROM Class c", Class.class).getResultList();
    }

    @Transactional
    @Override
    public void create(Class clazz) {
        entityManager.persist(clazz);
    }

    @Transactional
    @Override
    public void update(Class clazz) {
        entityManager.merge(clazz);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.createQuery("DELETE FROM Class c WHERE c.classId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }
}
