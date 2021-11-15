package by.mironenko.university.service.technical;

import by.mironenko.university.entity.StudentEntity;
import by.mironenko.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StudentTechnicalService {
    private static final String CANT_FIND_USER = "Can't find student with id ";
    private final StudentRepository studentRepository;

    public List<StudentEntity> findAll() {
        return StreamSupport
                .stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public StudentEntity findById(final Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(CANT_FIND_USER + id));
    }

    public StudentEntity save(final StudentEntity studentEntity) {
        studentEntity.setId(null);
        return studentRepository.save(studentEntity);
    }

    public void update(final StudentEntity studentEntity) {
        final StudentEntity existStudentEntity = findById(studentEntity.getId());
        existStudentEntity.setName(studentEntity.getName());
        existStudentEntity.setSurname(studentEntity.getSurname());
        studentRepository.save(existStudentEntity);
    }

    public void deleteById(final StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }
}
