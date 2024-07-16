package com.literalura;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookDAOTest {
    private BookDAO bookDAO;

    @BeforeEach
    public void setUp() {
        bookDAO = new BookDAO();
    }

    @AfterEach
    public void tearDown() {
        List<Book> books = bookDAO.getBooks();
        for (Book book : books) {
            bookDAO.deleteBook(book.getId());
        }
    }

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setIsbn("123456789");

        bookDAO.saveBook(book);

        List<Book> books = bookDAO.getBooks();
        assertEquals(1, books.size(), "There should be one book in the database");
    }

    @Test
    public void testGetBooks() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setIsbn("123456789");
        bookDAO.saveBook(book);

        List<Book> books = bookDAO.getBooks();
        assertTrue(books.size() > 0, "There should be at least one book in the database");
    }
}
