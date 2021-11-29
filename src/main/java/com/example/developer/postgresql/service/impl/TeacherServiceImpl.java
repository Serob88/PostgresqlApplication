package com.example.developer.postgresql.service.impl;

import com.example.developer.postgresql.entity.Review;
import com.example.developer.postgresql.entity.Teacher;
import com.example.developer.postgresql.repository.TeacherRepository;
import com.example.developer.postgresql.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

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

        if (teacher.getReviews() == null) {
            teacher.setReviews(new ArrayList<>());
        }

        teacher.getReviews().add(review);

        teacherRepository.save(teacher);

    }

    @Override
    public Teacher findById(String teacherID) {
        return teacherRepository.findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));
    }
}
