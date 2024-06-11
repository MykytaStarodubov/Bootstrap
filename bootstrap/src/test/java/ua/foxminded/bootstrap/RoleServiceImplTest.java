package ua.foxminded.bootstrap;



import ua.foxminded.bootstrap.dao.RoleRepository;
import ua.foxminded.bootstrap.model.Role;
import ua.foxminded.bootstrap.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

 

    @Test
    public void findRoleById_shouldThrowException_whenRoleNotFound() {
        when(roleRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RoleServiceImpl.RoleNotFoundException.class, () -> {
            roleService.findRoleById(1);
        });
    }

 
}
