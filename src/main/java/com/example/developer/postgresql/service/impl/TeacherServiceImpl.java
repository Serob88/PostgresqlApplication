package com.example.developer.postgresql.service.impl;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;
import com.example.developer.postgresql.repository.TeacherRepository;
import com.example.developer.postgresql.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

@Slf4j
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addReview(String teacherid, Review review) {
        Objects.requireNonNull(teacherid);
        Objects.requireNonNull(review);

        Teacher teacher = teacherRepository
                .findById(UUID.fromString(teacherid))
                .orElseThrow(() -> new EntityNotFoundException(teacherid));

        review.setDate(LocalDate.now());

        if (teacher.getInfos() == null) {
            teacher.setInfos(new ArrayList<>());
        }

//        teacher.getInfos()..add(review);

        teacherRepository.save(teacher);

    }

    @Override
    public Teacher findById(String teacherID) {
        return teacherRepository.findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void delete(String teacherId) {
        teacherRepository.deleteById(UUID.fromString(teacherId));
    }

    @Override
    public Teacher creat(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findByAuthor(String author) {
        return teacherRepository.findByReviewsAuthor(author);
    }
}
