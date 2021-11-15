package by.mironenko.university.entity;

import by.mironenko.university.dto.StudentDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "generator0")
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "students_books",
    joinColumns = @JoinColumn(name = "students_id"),
    inverseJoinColumns = @JoinColumn(name = "lectures_id"))
    private List<LectureEntity> lectures;

    public StudentEntity(final StudentDto studentDto) {
        this.id = studentDto.getId();
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();
        this.lectures = studentDto.getLectures().stream()
        .map(LectureEntity::new).collect(Collectors.toList());
    }

    public void addLecture(final LectureEntity lectureEntity) {
        this.lectures.add(lectureEntity);
    }
}
