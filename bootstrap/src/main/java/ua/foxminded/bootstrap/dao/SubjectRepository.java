package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    Optional<Subject> findById(int id);

    List<Subject> findAll();

    void create(Subject subject);

    void update(Subject subject);

    void deleteById(int id);
}
