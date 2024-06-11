package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject findSubjectById(int id);

    List<Subject> findAllSubjects();

    void createSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubjectById(int id);
}
