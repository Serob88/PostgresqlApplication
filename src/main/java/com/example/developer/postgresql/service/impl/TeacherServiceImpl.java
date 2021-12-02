package com.example.developer.postgresql.service.impl;

import com.example.developer.postgresql.entity.Teacher;
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
                .findById(UUID.fromString(teacherid))
                .orElseThrow(() -> new EntityNotFoundException(teacherid));


        teacher.setDetail(info);

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
