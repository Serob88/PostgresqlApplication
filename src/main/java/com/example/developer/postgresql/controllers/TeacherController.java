package com.example.developer.postgresql.controllers;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;
import com.example.developer.postgresql.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/teachers/{id}/review")
    public ResponseEntity<Void> addReview(@RequestBody Review review, @PathVariable("id") String teacherID) {

        log.info("Trying add review: {} in teacher by teacher id: {}", review, teacherID);

        try {
            teacherService.addReview(teacherID, review);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable String id) {

        log.info("Trying find teacher by id: {}", id);

        return ResponseEntity.ok(teacherService.findById(id));
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> findAll() {

        log.info("Trying find all teachers");

        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> creat(@RequestBody Teacher teacher) {

        log.info("Trying creat teacher: {}", teacher);

        return ResponseEntity.ok(teacherService.creat(teacher));
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        log.info("Trying delete teacher by id: {}", id);

        teacherService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/teachers/author/{author}")
    public ResponseEntity<List<Teacher>> findByAuthor (@PathVariable String author) {

        log.info("Trying to find teacher by author: {}", author);

        return ResponseEntity.ok(teacherService.findByAuthor(author));
    }

}
