package com.example.demo.repository;

import com.example.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This interface extends JpaRepository to provide CRUD operations for the Author entity
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}