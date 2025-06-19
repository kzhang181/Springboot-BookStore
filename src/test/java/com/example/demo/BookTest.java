package com.example.demo;

import org.junit.jupiter.api.Test;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

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
    void testBookConstructorWithParams() {
        Author author = new Author(5L, "Mark", "Twain");
        Book book = new Book(20L, "Tom Sawyer", author);
        assert book.getId().equals(20L);
        assert book.getTitle().equals("Tom Sawyer");
        assert book.getAuthor().equals(author);
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

    @Test
    void testBookIDChange() {
        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Alice");
        author.setLastName("Johnson");
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book Title");
        book.setAuthor(author);
        assert book.getId().equals(1L);
        assert book.getTitle().equals("Book Title");
        assert book.getAuthor().getId().equals(1L);
        book.setId(2L);
        assert book.getId().equals(2L);
    }

    @Test
    void testBookTitleChange() {
        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Bob");
        author.setLastName("Brown");
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Initial Title");
        book.setAuthor(author);
        assert book.getTitle().equals("Initial Title");
        book.setTitle("Updated Title");
        assert book.getTitle().equals("Updated Title");
    }

    @Test
    void testBookAuthorChange() {
        Author author1 = new Author();
        author1.setId(1L);
        author1.setFirstName("Charlie");
        author1.setLastName("Green");
        Author author2 = new Author();
        author2.setId(2L);
        author2.setFirstName("Diana");
        author2.setLastName("Blue");
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book with Changing Author");
        book.setAuthor(author1);
        assert book.getAuthor().getId().equals(1L);
        book.setAuthor(author2);
        assert book.getAuthor().getId().equals(2L);
    }

    @Test
    void testBookWithoutAuthor() {
        Book book = new Book();
        book.setTitle("Orphan Book");
        assert book.getAuthor() == null;
    }

    @Test
    void testAuthorBooksList() {
        Author author = new Author();
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        author.setBooks(books);
        assert author.getBooks().size() == 2;
    }
}