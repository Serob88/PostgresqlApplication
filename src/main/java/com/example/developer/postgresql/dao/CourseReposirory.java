package com.example.developer.postgresql.dao;

import com.example.developer.postgresql.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseReposirory extends CrudRepository<Course, UUID> {
}
