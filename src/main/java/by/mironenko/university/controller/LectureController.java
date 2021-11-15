package by.mironenko.university.controller;

import by.mironenko.university.dto.LectureDto;
import by.mironenko.university.service.LectureService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/lectures")
public class LectureController {
    private final LectureService lectureService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<LectureDto> getAllLectures() {
        return lectureService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LectureDto getLectureById(@NonNull @PathVariable("id") Long id) {
        return lectureService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createLecture(@RequestBody LectureDto lectureDto) {
        return lectureService.save(lectureDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateLecture(@RequestBody LectureDto lectureDto) {
        lectureService.update(lectureDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteLectureById(@NonNull @PathVariable("id") Long id) {
        lectureService.deleteById(id);
    }
}
