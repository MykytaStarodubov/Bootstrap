package ua.foxminded.bootstrap.service;


import ua.foxminded.bootstrap.dao.RoleRepository;
import ua.foxminded.bootstrap.model.Role;
import ua.foxminded.bootstrap.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found: " + id));
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public void createRole(Role role) {
        roleRepository.create(role);
    }

    @Transactional
    @Override
    public void updateRole(Role role) {
        roleRepository.update(role);
    }

    @Transactional
    @Override
    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    public static class RoleNotFoundException extends RuntimeException {
        public RoleNotFoundException(String message) {
            super(message);
        }
    }
}
