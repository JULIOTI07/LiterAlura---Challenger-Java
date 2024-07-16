package com.literalura;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookServiceTest {
    private BookService bookService;
    private BookDAO bookDAO;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
        bookDAO = new BookDAO();
    }

    @Test
    public void testFetchAndSaveBooks() {
        bookService.fetchAndSaveBooks();
        List<Book> books = bookDAO.getBooks();
        assertNotNull(books, "Books list should not be null");
        assertFalse(books.isEmpty(), "Books list should not be empty");
    }
}

