package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleRepository {
	Optional<Role> findById(int id);

	List<Role> findAll();

	void create(Role role);

	void update(Role role);

	void deleteById(int id);
}
