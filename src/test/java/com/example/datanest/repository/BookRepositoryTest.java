package com.example.datanest.repository;

import com.example.datanest.entity.Author;
import com.example.datanest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAllBooksWithAuthors() {
        Author author = new Author("Author 1", "USA");
        authorRepository.save(author);

        Book book1 = new Book("Book 1", 2020, author);
        Book book2 = new Book("Book 2", 2021, author);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books = bookRepository.findAllBooksWithAuthors();
        
        assertNotNull(books);
        assertTrue(books.size() >= 2);
        assertTrue(books.stream().anyMatch(b -> b.getTitle().equals("Book 1")));
        assertTrue(books.stream().allMatch(b -> b.getAuthor() != null));
    }
}
