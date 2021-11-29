package com.example.developer.postgresql.dao;

import com.example.developer.postgresql.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
}
