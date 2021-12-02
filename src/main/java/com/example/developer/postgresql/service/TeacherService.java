package com.example.developer.postgresql.service;

import com.example.developer.postgresql.entity.Teacher;

import com.example.developer.postgresql.model.TeacherDetail;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


public interface TeacherService {

    /**
     *Add review in teacher.
     * @param teacherID teacher id
     * @param info {@link TeacherDetail}
     * @throws javax.persistence.EntityNotFoundException
     */
    void addTeacherInfo(@NotNull String teacherID, @NotNull TeacherDetail info);

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
