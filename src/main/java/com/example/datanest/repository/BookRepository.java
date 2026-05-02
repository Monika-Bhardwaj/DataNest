package com.example.datanest.repository;

import com.example.datanest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Custom query method with inner join
    @Query("SELECT b FROM Book b JOIN b.author a")
    List<Book> findAllBooksWithAuthors();
}
