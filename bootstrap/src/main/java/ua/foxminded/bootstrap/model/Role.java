package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	private int roleId;
	private String roleTitle;
	private String roleDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id;

	@Column(name = "role_title")
	private String title;

	@Column(name = "role_description")
	private String description;

	public Role(int roleId, String roleTitle, String roleDescription) {
		this.roleId = roleId;
		this.roleTitle = roleTitle;
		this.roleDescription = roleDescription;
	}

	public void addRole() {
	}

	public void editRole() {
	}

	public void deleteRole() {
	}

	public void searchRole() {
	}

}
