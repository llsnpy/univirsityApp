package by.mironenko.university.dto;

import by.mironenko.university.entity.LectureEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureDto {
    private Long id;
    private String subjectName;
    private String lectorName;

    public LectureDto(final LectureEntity lectureEntity) {
        this.id = lectureEntity.getId();
        this.subjectName = lectureEntity.getSubjectName();
        this.lectorName = lectureEntity.getLectorName();
    }
}
