package com.example.demo.Controller;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

// This controller handles requests related to authors
@RestController
public class AuthorController {

    // This controller handles requests related to authors
    private final AuthorRepository authorRepository;

    // Constructor injection for the AuthorRepository
    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Endpoints for managing authors
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        // This method should return a list of all authors
        return authorRepository.findAll();
    }

    // Endpoint to get an author by their ID
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        // This method should create a new author
        return authorRepository.save(author); // In a real application, you would save the author to the database
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        // This method should delete an author by their ID
        authorRepository.deleteById(id); // In a real application, you would delete the author from the database
    }
}