package ua.foxminded.bootstrap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.bootstrap.dao.UserRepository;
import ua.foxminded.bootstrap.exception.UserNotFoundException;
import ua.foxminded.bootstrap.model.User;
import ua.foxminded.bootstrap.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + id));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.create(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
