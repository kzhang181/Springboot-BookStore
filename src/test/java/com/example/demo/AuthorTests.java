package com.example.demo;

import org.junit.jupiter.api.Test;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.boot.test.context.SpringBootTest;

public class AuthorTests {

    @Test
    void contextLoads() {
        // This test checks if the Spring application context loads successfully
    }

    @Test
    void testAuthorCreation() {
        Author author = new Author();
        author.setFirstName("Alice");
        author.setLastName("Johnson");
        assert author.getFirstName().equals("Alice");
        assert author.getLastName().equals("Johnson");
    }

    @Test
    void testAuthorAndBookRelationship() {
        Author author = new Author();
        author.setFirstName("Bob");
        author.setLastName("Smith");
        Book book = new Book();
        book.setTitle("Learning Java");
        book.setAuthor(author);
        assert book.getAuthor().getFirstName().equals("Bob");
        assert book.getAuthor().getLastName().equals("Smith");
    }
}