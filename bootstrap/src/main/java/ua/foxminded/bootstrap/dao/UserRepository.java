package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int id);

    List<User> findAll();

    void create(User user);

    void update(User user);

    void deleteById(int id);
}
