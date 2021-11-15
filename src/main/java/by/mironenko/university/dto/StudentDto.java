package by.mironenko.university.dto;

import by.mironenko.university.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private List<LectureDto> lectures;

    public StudentDto(final StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
        this.surname = studentEntity.getSurname();
        this.lectures = studentEntity.getLectures()
                .stream()
                .map(LectureDto::new)
                .collect(Collectors.toList());
    }
}
