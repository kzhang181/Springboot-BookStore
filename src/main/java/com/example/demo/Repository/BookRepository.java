package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// This interface extends JpaRepository to provide CRUD operations for the Book entity
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}