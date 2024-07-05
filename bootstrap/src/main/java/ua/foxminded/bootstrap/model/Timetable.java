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

	@Column(name = "timetable_description")
	private String timetableDescription;

	@Column(name = "timetable_type")
	private String timetableType;

	@Column(name = "timetable_name")
	private String timetableName;

	@OneToMany(mappedBy = "timetable")
	private Set<Class> classes;

	public Timetable(int timetableId, String timetableDescription, String timetableType, String timetableName) {
		this.timetableId = timetableId;
		this.timetableDescription = timetableDescription;
		this.timetableType = timetableType;
		this.timetableName = timetableName;
	}
}
