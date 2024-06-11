package ua.foxminded.bootstrap.model;

import ua.foxminded.bootstrap.model.User;

public class Student extends User {
	private String studentMobile;
	private String studentUsername;
	private String studentPassword;
	private int studentCollegeId;

	public Student(int userId, int userRoleId, String userName, String userEmail, String userDob, String userAddress,
			String studentMobile, String studentUsername, String studentPassword, int studentCollegeId) {
		super(userId, userRoleId, userName, userEmail, userDob, userAddress);
		this.studentMobile = studentMobile;
		this.studentUsername = studentUsername;
		this.studentPassword = studentPassword;
		this.studentCollegeId = studentCollegeId;
	}

	public void addStudent() {
	}

	public void editStudent() {
	}

	public void deleteStudent() {
	}

	public void searchStudent() {
	}
}
