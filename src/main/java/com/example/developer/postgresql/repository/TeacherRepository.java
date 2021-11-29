package com.example.developer.postgresql.repository;

import com.example.developer.postgresql.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
}
