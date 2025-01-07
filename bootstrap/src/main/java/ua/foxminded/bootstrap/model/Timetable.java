package ua.foxminded.bootstrap.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "timetables")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_id")
    private int timetableId;

    @Column(name = "timetable_name", nullable = false)
    private String timetableName;

    @Column(name = "timetable_description")
    private String timetableDescription;

    @Column(name = "timetable_type")
    private String timetableType;

    @OneToMany(mappedBy = "timetable", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UniversityClass> classes;
    
    public Timetable() {
    	
    }
    public Timetable(int timetableId, String timetableDescription, String timetableType, String timetableName) {
        this.timetableId = timetableId;
        this.timetableDescription = timetableDescription;
        this.timetableType = timetableType;
        this.timetableName = timetableName;
    }
}
