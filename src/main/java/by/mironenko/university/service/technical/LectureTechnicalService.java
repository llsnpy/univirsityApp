package by.mironenko.university.service.technical;

import by.mironenko.university.entity.LectureEntity;
import by.mironenko.university.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LectureTechnicalService {
    private static final String CANT_FIND_BOOK = "Can't find book with id ";
    private final LectureRepository lectureRepository;

    public List<LectureEntity> findAll() {
        return StreamSupport
                .stream(lectureRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public LectureEntity findById(final Long id) {
        return lectureRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(CANT_FIND_BOOK + id));
    }

    public LectureEntity save(final LectureEntity lectureEntity) {
        lectureEntity.setId(null);
        return lectureRepository.save(lectureEntity);
    }

    public void update(final LectureEntity lectureEntity) {
        final LectureEntity existLectureEntity = findById(lectureEntity.getId());
        existLectureEntity.setSubjectName(lectureEntity.getSubjectName());
        existLectureEntity.setLectorName(lectureEntity.getLectorName());
        lectureRepository.save(existLectureEntity);
    }

    public void deleteById(final LectureEntity lectureEntity) {
        lectureRepository.delete(lectureEntity);
    }
}
