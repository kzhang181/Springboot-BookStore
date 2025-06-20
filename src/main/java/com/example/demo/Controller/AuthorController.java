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

    // Reads the list of authors (Read)
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        // This method should return a list of all authors
        return authorRepository.findAll();
    }

    // Creating Authors (Create)
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        // This method should create a new author
        return authorRepository.save(author);
    }

    // Managing authors (Delete, Update)
    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        // This method should delete an author by their ID
        authorRepository.deleteById(id);
    }

    // Update an author by their ID (Update)
    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authorRepository.findById(id)
            .map(author -> {
                author.setFirstName(updatedAuthor.getFirstName());
                author.setLastName(updatedAuthor.getLastName());
                return authorRepository.save(author);
            })
            .orElseThrow(() -> new RuntimeException("Author not found"));
    }
}