package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.UniversityClass;
import java.util.List;
import java.util.Optional;

public interface ClassRepository {
    Optional<UniversityClass> findById(int id);

    List<UniversityClass> findAll();

    void create(UniversityClass claSS);

    void update(UniversityClass claSS);

    void deleteById(int id);
}
