package ua.foxminded.bootstrap;

import ua.foxminded.bootstrap.controller.*;

import ua.foxminded.bootstrap.model.Role;
import ua.foxminded.bootstrap.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(RoleController.class)
public class RoleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoleService roleService;

	@Test
	@WithMockUser(username = "user")
	public void testListRoles() throws Exception {
		Role role1 = new Role("Admin");
		role1.setRoleId(1);
		role1.setUsers(null); 

		Role role2 = new Role("Teacher");
		role2.setRoleId(2);
		role2.setUsers(null); 

		when(roleService.findAllRoles()).thenReturn(Arrays.asList(role1, role2));

		mockMvc.perform(get("/roles")).andExpect(status().isOk()).andExpect(view().name("roles"))
				.andExpect(model().attributeExists("roles"))
				.andExpect(model().attribute("roles", Arrays.asList(role1, role2)));
	}
}
