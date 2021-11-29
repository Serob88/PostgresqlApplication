package com.example.developer.postgresql.service.impl;

import com.example.developer.postgresql.entities.Review;
import com.example.developer.postgresql.entities.Teacher;
import com.example.developer.postgresql.service.TeacherService;
import com.example.developer.postgresql.dao.TeacherRepository;
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
    public void addReview(String teacherID, Review review) {
        Objects.requireNonNull(teacherID);
        Objects.requireNonNull(review);

        Teacher teacher = teacherRepository
                .findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));

        review.setDate(LocalDate.now());

        if(teacher.getReviews() == null){
            teacher.setReviews(new ArrayList<>());
        }

        teacher.getReviews().add(review);

        teacherRepository.save(teacher);

    }
}
