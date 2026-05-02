package com.example.datanest;

import com.example.datanest.entity.Author;
import com.example.datanest.entity.Book;
import com.example.datanest.repository.AuthorRepository;
import com.example.datanest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (authorRepository.count() == 0) {
            Author author1 = new Author("J.K. Rowling", "UK");
            Author author2 = new Author("George R.R. Martin", "USA");
            Author author3 = new Author("J.R.R. Tolkien", "UK");
            Author author4 = new Author("Agatha Christie", "UK");
            Author author5 = new Author("Stephen King", "USA");
            Author author6 = new Author("Isaac Asimov", "Russia/USA");
            Author author7 = new Author("Arthur C. Clarke", "UK");
            Author author8 = new Author("Frank Herbert", "USA");
            Author author9 = new Author("F. Scott Fitzgerald", "USA");
            Author author10 = new Author("Jane Austen", "UK");

            authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5, author6, author7, author8, author9, author10));

            Book book1 = new Book("Harry Potter and the Sorcerer's Stone", 1997, author1);
            Book book2 = new Book("A Game of Thrones", 1996, author2);
            Book book3 = new Book("The Fellowship of the Ring", 1954, author3);
            Book book4 = new Book("And Then There Were None", 1939, author4);
            Book book5 = new Book("The Shining", 1977, author5);
            Book book6 = new Book("Foundation", 1951, author6);
            Book book7 = new Book("2001: A Space Odyssey", 1968, author7);
            Book book8 = new Book("Dune", 1965, author8);
            Book book9 = new Book("The Great Gatsby", 1925, author9);
            Book book10 = new Book("Pride and Prejudice", 1813, author10);

            bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
        }
    }
}
