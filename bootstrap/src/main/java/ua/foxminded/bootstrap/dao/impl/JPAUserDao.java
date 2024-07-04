package ua.foxminded.bootstrap.dao.impl;

import ua.foxminded.bootstrap.dao.UserRepository;
import ua.foxminded.bootstrap.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAUserDao implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.userId = :id")
                     .setParameter("id", id)
                     .executeUpdate();
    }

    @Transactional
    @Override
    public void save(User user) {
        if (user.getUserId() == 0) {
            create(user);
        } else {
            update(user);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                            .setParameter("username", username)
                            .getResultList().stream().findFirst();
    }
}
