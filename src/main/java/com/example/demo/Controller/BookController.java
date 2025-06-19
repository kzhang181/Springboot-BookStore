package com.example.demo.Controller;

import com.example.demo.repository.BookRepository;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    // This controller handles requests related to books
    private final BookRepository bookRepository;

    // Constructor injection for the BookRepository
    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Endpoints for managing books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        // Returns a list of all books
        return bookRepository.findAll();
    }

    // Endpoint to get a book by its ID
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        // Creates a new book
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        // Deletes a book by its ID
        bookRepository.deleteById(id);
    }
    
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
            .map(book -> {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                return bookRepository.save(book);
            })
            .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}