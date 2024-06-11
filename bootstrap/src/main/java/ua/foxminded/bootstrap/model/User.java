package ua.foxminded.bootstrap.model;

public class User {
	private int userId;
	private int userRoleId;
	private String userName;
	private String userEmail;
	private String userDob;
	private String userAddress;

	public User(int userId, int userRoleId, String userName, String userEmail, String userDob, String userAddress) {
		this.userId = userId;
		this.userRoleId = userRoleId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userDob = userDob;
		this.userAddress = userAddress;
	}

	public void addUser() {
	}

	public void editUser() {
	}

	public void deleteUser() {
	}

	public void searchUser() {
	}
}
