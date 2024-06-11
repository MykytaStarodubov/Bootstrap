package ua.foxminded.bootstrap.service;

import ua.foxminded.bootstrap.dao.SubjectRepository;
import ua.foxminded.bootstrap.model.Subject;
import ua.foxminded.bootstrap.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found: " + id));
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional
    @Override
    public void createSubject(Subject subject) {
        subjectRepository.create(subject);
    }

    @Transactional
    @Override
    public void updateSubject(Subject subject) {
        subjectRepository.update(subject);
    }

    @Transactional
    @Override
    public void deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
    }

    public static class SubjectNotFoundException extends RuntimeException {
        public SubjectNotFoundException(String message) {
            super(message);
        }
    }
}
