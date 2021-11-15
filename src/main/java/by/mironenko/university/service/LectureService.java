package by.mironenko.university.service;

import by.mironenko.university.dto.LectureDto;
import by.mironenko.university.entity.LectureEntity;
import by.mironenko.university.service.technical.LectureTechnicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureTechnicalService lectureTechnicalService;

    public List<LectureDto> getAll() {
        return lectureTechnicalService.findAll()
                .stream()
                .map(LectureDto::new)
                .collect(Collectors.toList());
    }

    public LectureDto getById(final Long id) {
        return new LectureDto(lectureTechnicalService.findById(id));
    }

    public Long save(final LectureDto lectureDto) {
        return lectureTechnicalService.save(new LectureEntity(lectureDto)).getId();
    }

    public void update(final LectureDto lectureDto) {
        lectureTechnicalService.update(new LectureEntity(lectureDto));
    }

    public void deleteById(final Long id) {
        lectureTechnicalService.deleteById(lectureTechnicalService.findById(id));
    }
}
