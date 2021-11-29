package com.example.developer.postgresql.repository;

import com.example.developer.postgresql.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseReposirory extends JpaRepository<Course, UUID> {
}
