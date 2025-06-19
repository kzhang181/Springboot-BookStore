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
    void testAuthorConstructorWithParams() {
        Author author = new Author(10L, "Emily", "Bronte");
        assert author.getId().equals(10L);
        assert author.getFirstName().equals("Emily");
        assert author.getLastName().equals("Bronte");
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

    @Test
    void testAuthorIDChange(){
        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Charlie");
        author.setLastName("Brown");
        assert author.getId().equals(1L);
        assert author.getFirstName().equals("Charlie");
        assert author.getLastName().equals("Brown");
        author.setId(2L);
        assert author.getId().equals(2L);
    }

    @Test
    void testAuthorNameChange() {
        Author author = new Author();
        author.setId(1L);
        author.setFirstName("David");
        author.setLastName("White");
        assert author.getFirstName().equals("David");
        assert author.getLastName().equals("White");
        author.setFirstName("Daniel");
        author.setLastName("Black");
        assert author.getFirstName().equals("Daniel");
        assert author.getLastName().equals("Black");
    }
}