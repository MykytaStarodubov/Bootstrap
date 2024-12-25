package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Role;

import java.util.List;

public interface RoleService {
	Role findRoleById(int id);

	List<Role> findAllRoles();

	void createRole(Role role);

	void updateRole(Role role);

	void deleteRoleById(int id);
}
