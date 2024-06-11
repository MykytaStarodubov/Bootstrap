package ua.foxminded.bootstrap.model;

public class Class {
	private int classId;
	private String className;
	private String classDescription;
	private String classType;
	private int classStudentId;
	private String classRoom;

	public Class(int classId, String className, String classDescription, String classType, int classStudentId,
			String classRoom) {
		this.classId = classId;
		this.className = className;
		this.classDescription = classDescription;
		this.classType = classType;
		this.classStudentId = classStudentId;
		this.classRoom = classRoom;
	}

	public void addClass() {
	}

	public void editClass() {
	}

	public void deleteClass() {
	}

	public void searchClass() {
	}
}
