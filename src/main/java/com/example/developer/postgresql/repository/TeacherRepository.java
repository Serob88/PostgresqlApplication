package com.example.developer.postgresql.repository;

import com.example.developer.postgresql.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    @Query(value = "SELECT * FROM teacher t CROSS JOIN jsonb_array_elements(reviews) " +
            "where value ->> 'author' = :author", nativeQuery = true)
    List<Teacher> findByReviewsAuthor(String author);
}
