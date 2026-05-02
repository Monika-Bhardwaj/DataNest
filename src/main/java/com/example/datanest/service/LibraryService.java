package com.example.datanest.service;

import com.example.datanest.entity.Author;
import com.example.datanest.entity.Book;
import com.example.datanest.repository.AuthorRepository;
import com.example.datanest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooksWithAuthors() {
        return bookRepository.findAllBooksWithAuthors();
    }

    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Author getAuthorById(Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        return optional.orElse(null);
    }

    public Book getBookById(Long id) {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(null);
    }

    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
