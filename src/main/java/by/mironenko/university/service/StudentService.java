package by.mironenko.university.service;

import by.mironenko.university.dto.StudentDto;
import by.mironenko.university.entity.StudentEntity;
import by.mironenko.university.service.technical.LectureTechnicalService;
import by.mironenko.university.service.technical.StudentTechnicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentTechnicalService studentTechnicalService;
    private final LectureTechnicalService lectureTechnicalService;

    public List<StudentDto> getAll() {
        return studentTechnicalService.findAll()
                .stream()
                .map(StudentDto::new)
                .collect(Collectors.toList());
    }

    public StudentDto getById(final Long id) {
        return new StudentDto(studentTechnicalService.findById(id));
    }

    @Transactional
    public Long save(final StudentDto studentDto) {
        return studentTechnicalService.save(new StudentEntity(studentDto)).getId();
    }

    public void update(final StudentDto studentDto) {
        studentTechnicalService.update(new StudentEntity(studentDto));
    }

    public void deleteById(final Long id) {
        studentTechnicalService.deleteById(studentTechnicalService.findById(id));
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addLectureToStudent(final Long studentId, final Long lectureId) {
        studentTechnicalService.findById(studentId).addLecture(lectureTechnicalService.findById(lectureId));
        //todo update
        /*studentTechnicalService.update();*/
    }
}
