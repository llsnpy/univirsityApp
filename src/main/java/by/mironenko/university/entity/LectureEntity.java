package by.mironenko.university.entity;

import by.mironenko.university.dto.LectureDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lectures")
@NoArgsConstructor
@Getter
@Setter
public class LectureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subjectName;

    @Column
    private String lectorName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "students_lectures",
    joinColumns = @JoinColumn(name = "lectures_id"),
    inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<StudentEntity> studentsEntity;

    public LectureEntity(final LectureDto lectureDto) {
        this.id = lectureDto.getId();
       this.subjectName = lectureDto.getSubjectName();
        this.lectorName = lectureDto.getLectorName();
    }
}
