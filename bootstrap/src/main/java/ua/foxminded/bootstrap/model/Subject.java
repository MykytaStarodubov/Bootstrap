package ua.foxminded.bootstrap.model;

public class Subject {
	private int subjectId;
	private String subjectName;
	private String subjectType;
	private String subjectDescription;
	private int subjectStudentId;

	public Subject(int subjectId, String subjectName, String subjectType, String subjectDescription,
			int subjectStudentId) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectType = subjectType;
		this.subjectDescription = subjectDescription;
		this.subjectStudentId = subjectStudentId;
	}

	public void addSubject() {
	}

	public void editSubject() {
	}

	public void deleteSubject() {
	}

	public void searchSubject() {
	}
}
