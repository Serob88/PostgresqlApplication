package com.example.developer.postgresql.repository;

import com.example.developer.postgresql.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseReposirory extends CrudRepository<Course, UUID> {
}
