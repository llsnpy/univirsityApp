package by.mironenko.university.controller;

import by.mironenko.university.dto.StudentDto;
import by.mironenko.university.service.StudentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @RequestMapping(value = "/students/{student_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentById(@NonNull @PathVariable("student_id") Long id) {
        return studentService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createStudent(@RequestBody StudentDto studentDto) {
        studentDto.setLectures(Collections.emptyList());
        return studentService.save(studentDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentDto.setLectures(Collections.emptyList());
        studentService.update(studentDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@NonNull @PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    @RequestMapping(value = "/{user_id}/{book_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addLectureToStudent(@PathVariable("student_id") Long studentId, @PathVariable("lecture_id") Long lectureId) {
        studentService.addLectureToStudent(studentId, lectureId);
    }
}
