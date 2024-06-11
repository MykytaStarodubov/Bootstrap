package ua.foxminded.bootstrap;

import ua.foxminded.bootstrap.dao.RoleRepository;
import ua.foxminded.bootstrap.model.Role;
import ua.foxminded.bootstrap.service.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
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

    @Test
    public void findRoleById_shouldReturnRole_whenRoleFound() {
        Role role = new Role("Admin");
        role.setRoleId(1);
        when(roleRepository.findById(1)).thenReturn(Optional.of(role));

        Role foundRole = roleService.findRoleById(1);

        assertEquals(role, foundRole);
        verify(roleRepository).findById(1);
    }

    @Test
    public void findAllRoles_shouldReturnAllRoles() {
        Role role1 = new Role("Admin");
        role1.setRoleId(1);
        Role role2 = new Role("User");
        role2.setRoleId(2);
        List<Role> roles = Arrays.asList(role1, role2);

        when(roleRepository.findAll()).thenReturn(roles);

        List<Role> foundRoles = roleService.findAllRoles();

        assertEquals(roles, foundRoles);
        verify(roleRepository).findAll();
    }

    @Test
    public void createRole_shouldSaveRole() {
        Role role = new Role("Manager");

        roleService.createRole(role);

        verify(roleRepository).create(role);
    }

    @Test
    public void updateRole_shouldUpdateExistingRole() {
        Role role = new Role("User");
        role.setRoleId(2);

        roleService.updateRole(role);

        verify(roleRepository).update(role);
    }

    @Test
    public void deleteRoleById_shouldDeleteRole() {
        int idToDelete = 1;

        roleService.deleteRoleById(idToDelete);

        verify(roleRepository).deleteById(idToDelete);
    }
}
