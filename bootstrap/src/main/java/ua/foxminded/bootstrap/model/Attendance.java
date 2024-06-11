package ua.foxminded.bootstrap.model;

public class Attendance {
	private int attendanceId;
	private int attendanceStudentId;
	private String attendanceType;
	private String attendanceDescription;

	public Attendance(int attendanceId, int attendanceStudentId, String attendanceType, String attendanceDescription) {
		this.attendanceId = attendanceId;
		this.attendanceStudentId = attendanceStudentId;
		this.attendanceType = attendanceType;
		this.attendanceDescription = attendanceDescription;
	}

	public void addAttendance() {
	}

	public void editAttendance() {
	}

	public void deleteAttendance() {
	}

	public void searchAttendance() {
	}
}
