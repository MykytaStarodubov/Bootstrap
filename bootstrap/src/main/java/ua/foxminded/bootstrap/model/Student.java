package ua.foxminded.bootstrap.model;

import ua.foxminded.bootstrap.model.User;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_mobile")
    private String studentMobile;

    @Column(name = "student_email", nullable = false)
    private String studentEmail;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "student_username", nullable = false)
    private String studentUsername;

    @Column(name = "student_password", nullable = false)
    private String studentPassword;

    @Column(name = "student_college_id")
    private int studentCollegeId;

    @OneToMany(mappedBy = "student")
    private Set<Attendance> attendances;

	public Student(int userId, int userRoleId, String userName, String userEmail, String userDob, String userAddress,
			String studentMobile, String studentUsername, String studentPassword, int studentCollegeId) {
		super();
		this.studentMobile = studentMobile;
		this.studentUsername = studentUsername;
		this.studentPassword = studentPassword;
		this.studentCollegeId = studentCollegeId;
	}
	public Student(int studentId, String studentName) {
	    this.studentId = studentId;
	    this.studentName = studentName;
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
