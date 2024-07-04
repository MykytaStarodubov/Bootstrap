package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.User;
import java.util.List;

public interface UserService {
    User findUserById(Long id);

    List<User> findAllUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
