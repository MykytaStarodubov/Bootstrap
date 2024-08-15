package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private int attendanceId;

	@ManyToOne
	@JoinColumn(name = "attendance_student_id", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "attendance_subject_id", nullable = false)
	private Subject subject;

	@Column(name = "attendance_type")
	private String attendanceType;

	@Column(name = "attendance_description")
	private String attendanceDescription;

	public Attendance(Student student, Subject subject, String attendanceType, String attendanceDescription) {
		this.student = student;
		this.subject = subject;
		this.attendanceType = attendanceType;
		this.attendanceDescription = attendanceDescription;
	}

	public Attendance() {
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public String getAttendanceDescription() {
		return attendanceDescription;
	}

	public void setAttendanceDescription(String attendanceDescription) {
		this.attendanceDescription = attendanceDescription;
	}
}
