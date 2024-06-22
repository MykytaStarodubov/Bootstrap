package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
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

    public Subject() {}

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(int subjectId, String subjectName, String subjectType, String subjectDescription, int subjectStudentId) {
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public int getSubjectStudentId() {
        return subjectStudentId;
    }

    public void setSubjectStudentId(int subjectStudentId) {
        this.subjectStudentId = subjectStudentId;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
}
