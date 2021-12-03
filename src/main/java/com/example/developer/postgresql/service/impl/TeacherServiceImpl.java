package com.example.developer.postgresql.service.impl;

import com.example.developer.postgresql.entity.Teacher;
import com.example.developer.postgresql.model.Review;
import com.example.developer.postgresql.model.TeacherDetail;
import com.example.developer.postgresql.repository.TeacherRepository;
import com.example.developer.postgresql.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addTeacherInfo(String teacherid, TeacherDetail info) {
        Objects.requireNonNull(teacherid);
        Objects.requireNonNull(info);

        Teacher teacher = teacherRepository
                .findById(teacherid)
                .orElseThrow(() -> new EntityNotFoundException(teacherid));


        teacher.setDetail(info);

        teacherRepository.save(teacher);

    }

    @Override
    public Teacher findById(String teacherID) {
        return teacherRepository.findById(teacherID)
                .orElseThrow(() -> new EntityNotFoundException(teacherID));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void delete(String teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher creat(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findByAuthor(String author) {
        return teacherRepository.findByReviewsAuthor(author);
    }


    public Teacher updateTeacher(String Id, String author, String updateAuthor) {
        Teacher teacher = teacherRepository.findById(Id).orElse(new Teacher());
        List<Review> reviews = teacher.getDetail().getReviews().stream().map(review -> {
            Review newReview = review;
            if (review.getAuthor().equals(author)) {
                newReview = Review.builder()
                        .author(updateAuthor)
                        .review(review.getReview())
                        .build();
                return newReview;
            }
            return newReview;
        }).collect(Collectors.toList());
        teacher.getDetail().setReviews(reviews);
        return teacherRepository.save(teacher);
    }
}
