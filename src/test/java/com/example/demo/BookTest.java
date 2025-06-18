package com.example.demo;

import org.junit.jupiter.api.Test;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.boot.test.context.SpringBootTest;

class BookTest {
    @Test
    void contextLoads() {
        // This test checks if the Spring application context loads successfully
    }

    @Test
    void testBookCreation() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor(author);
        assert book.getTitle().equals("Test Book");
        assert book.getAuthor().getFirstName().equals("John");
        assert book.getAuthor().getLastName().equals("Doe");
    }

    @Test
    void testBookandAuthorRelationship() {
        Author author = new Author();
        author.setFirstName("Jane");
        author.setLastName("Smith");
        Book book = new Book();
        book.setTitle("Another Test Book");
        book.setAuthor(author);
        assert book.getAuthor().getId() == author.getId();
    }
}