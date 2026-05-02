package com.example.datanest.service;

import com.example.datanest.entity.Author;
import com.example.datanest.entity.Book;
import com.example.datanest.repository.AuthorRepository;
import com.example.datanest.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LibraryService libraryService;

    private Author testAuthor;
    private Book testBook;

    @BeforeEach
    void setUp() {
        testAuthor = new Author("Test Author", "Test Country");
        testAuthor.setId(1L);

        testBook = new Book("Test Book", 2024, testAuthor);
        testBook.setId(1L);
    }

    @Test
    void testSaveAuthor() {
        when(authorRepository.save(any(Author.class))).thenReturn(testAuthor);
        Author savedAuthor = libraryService.saveAuthor(testAuthor);
        assertNotNull(savedAuthor);
        assertEquals("Test Author", savedAuthor.getName());
        verify(authorRepository, times(1)).save(testAuthor);
    }

    @Test
    void testGetAllAuthors() {
        when(authorRepository.findAll()).thenReturn(Arrays.asList(testAuthor));
        List<Author> authors = libraryService.getAllAuthors();
        assertEquals(1, authors.size());
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    void testGetAuthorById() {
        when(authorRepository.findById(1L)).thenReturn(Optional.of(testAuthor));
        Author author = libraryService.getAuthorById(1L);
        assertNotNull(author);
        assertEquals("Test Author", author.getName());
    }

    @Test
    void testSaveBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(testBook);
        Book savedBook = libraryService.saveBook(testBook);
        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
        verify(bookRepository, times(1)).save(testBook);
    }

    @Test
    void testGetAllBooksWithAuthors() {
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Arrays.asList(testBook));
        List<Book> books = libraryService.getAllBooksWithAuthors();
        assertEquals(1, books.size());
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    void testGetBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
        Book book = libraryService.getBookById(1L);
        assertNotNull(book);
        assertEquals("Test Book", book.getTitle());
    }
}
