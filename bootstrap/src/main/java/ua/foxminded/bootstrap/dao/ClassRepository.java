package ua.foxminded.bootstrap.dao;

import ua.foxminded.bootstrap.model.Class;
import java.util.List;
import java.util.Optional;

public interface ClassRepository {
    Optional<Class> findById(int id);

    List<Class> findAll();

    void create(Class claSS);

    void update(Class claSS);

    void deleteById(int id);
}
