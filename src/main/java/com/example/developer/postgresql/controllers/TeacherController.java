package com.example.developer.postgresql.controllers;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;
import com.example.developer.postgresql.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/teachers/{id}/review")
    public ResponseEntity addReview(@RequestBody Review review, @PathVariable("id") String teacherID) {

        log.info("Trying add review: {} in teacher by teacher id: {}", review, teacherID);

        try {
            teacherService.addReview(teacherID, review);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teachers/{id}/")
    public ResponseEntity<Teacher> findById(@PathVariable String teacherId) {

        log.info("Trying find teacher by id: {}", teacherId);

        return ResponseEntity.ok(teacherService.findById(teacherId));
    }


}
