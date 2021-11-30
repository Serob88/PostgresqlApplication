package com.example.developer.postgresql.service;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


public interface TeacherService {

    /**
     *Add review in teacher.
     * @param teacherID teacher id
     * @param review {@link Review}
     * @throws javax.persistence.EntityNotFoundException
     */
    void addReview(@NotNull String teacherID, @NotNull Review review);

    /**
     * Find teacher by id.
     *
     * @param teacherId teacher id
     * @return Teacher {@link Teacher}
     */
    Teacher findById(@NotNull String teacherId);

    /**
     * Find all teachers.
     * @return Teacher {@link Teacher}
     */
    List<Teacher> findAll();

    /**
     * Remove teacher by id.
     *
     * @param teacherId teacher id
     */
    void delete(@NotNull String teacherId);

    /**
     * Creat teacher.
     *
     * @param teacher {@link Teacher}
     * @return Teacher
     */
    Teacher creat(@NotNull Teacher teacher);

    List<Teacher> findByAuthor(@NotBlank String author);
}
