package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.RoleRepository;
import ua.foxminded.bootstrap.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPARoleDao implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Role> findById(int id) {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Transactional
    @Override
    public void create(Role role) {
        entityManager.persist(role);
    }

    @Transactional
    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.createQuery("DELETE FROM Role r WHERE r.roleId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }
}