package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.dao.ClassRepository;
import ua.foxminded.bootstrap.model.Class;
import ua.foxminded.bootstrap.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class findClassById(int id) throws ClassNotFoundException {
        return classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Class not found: " + id));
    }

    @Override
    public List<Class> findAllClasses() {
        return classRepository.findAll();
    }

    @Transactional
    @Override
    public void createClass(Class claSS) {
        classRepository.create(claSS);
    }

    @Transactional
    @Override
    public void updateClass(Class claSS) {
        classRepository.update(claSS);
    }

    @Transactional
    @Override
    public void deleteClassById(int id) {
        classRepository.deleteById(id);
    }
}