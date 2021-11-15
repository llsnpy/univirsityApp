package by.mironenko.university.repository;

import by.mironenko.university.entity.LectureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<LectureEntity, Long> {
}
