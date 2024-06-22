package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "id")
    private int id;

    @Column(name = "class_description")
    private String classDescription;

    @Column(name = "class_type")
    private String classType;

    @ManyToOne
    @JoinColumn(name = "class_student_id")
    private Student classStudentId;

    @Column(name = "class_room")
    private String classRoom;
    
    @ManyToOne
    @JoinColumn(name = "timetable_id")
    private Timetable timetable;
    
    @ManyToMany
    @JoinTable(name = "class_subject", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    public Class(int id, String name, int classId, String className, String classDescription, String classType,
    		Student classStudentId, String classRoom) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.className = className;
        this.classDescription = classDescription;
        this.classType = classType;
        this.classStudentId = classStudentId;
        this.classRoom = classRoom;
    }

    public Class(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
