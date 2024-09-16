package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "subjects")
@ToString
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private int subjectId;

	@Column(name = "subject_name", nullable = false)
	private String subjectName;

	@Column(name = "subject_type")
	private String subjectType;

	@Column(name = "subject_description")
	private String subjectDescription;

	@Column(name = "subject_Student_Id")
	private int subjectStudentId;

	@ManyToMany(mappedBy = "subjects")
	private Set<Class> classes;

	@OneToMany(mappedBy = "subject")
	private Set<Attendance> attendances;

	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	public Subject() {

	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Subject(int subjectId, String subjectName, String subjectType, String subjectDescription,
			int subjectStudentId) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectType = subjectType;
		this.subjectDescription = subjectDescription;
		this.subjectStudentId = subjectStudentId;
	}

	public Subject(int subjectId, String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

}
