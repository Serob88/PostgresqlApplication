package com.example.developer.postgresql.service;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;

import javax.validation.constraints.NotNull;


public interface TeacherService {

    /**
     *
     * @param teacherID
     * @param review
     * @throws javax.persistence.EntityNotFoundException
     */
    void addReview(@NotNull String teacherID, @NotNull Review review);

    /**
     * Find teacher by id.
     *
     * @param teacherId teacher id
     * @return Teacher {@link Teacher}
     */
    Teacher findById(String teacherId);
}
