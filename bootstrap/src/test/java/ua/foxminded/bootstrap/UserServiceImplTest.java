package ua.foxminded.bootstrap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.bootstrap.dao.UserRepository;
import ua.foxminded.bootstrap.exception.UserNotFoundException;
import ua.foxminded.bootstrap.model.User;
import ua.foxminded.bootstrap.service.impl.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findUserById_shouldThrowException_whenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findUserById(1L));
    }

    @Test
    public void createUser_shouldSaveUser() {
        User newUser = new User("John Doe", "john@example.com");

        userService.createUser(newUser);

        verify(userRepository).create(newUser);
    }

    @Test
    public void updateUser_shouldUpdateExistingUser() {
        User user = new User("Isabella Doe", "isa@example.com");

        userService.updateUser(user);

        verify(userRepository).update(user);
    }

    @Test
    public void deleteUserById_shouldDeleteUser() {
        Long idToDelete = 1L;

        userService.deleteUserById(idToDelete);

        verify(userRepository).deleteById(idToDelete);
    }
}
