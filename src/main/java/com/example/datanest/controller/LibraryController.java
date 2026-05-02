package com.example.datanest.controller;

import com.example.datanest.entity.Author;
import com.example.datanest.entity.Book;
import com.example.datanest.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String viewHomePage(Model model) {
        List<Book> books = libraryService.getAllBooksWithAuthors();
        model.addAttribute("books", books);
        List<Author> authors = libraryService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "list";
    }

    @GetMapping("/addAuthor")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author, Model model) {
        try {
            libraryService.saveAuthor(author);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Integrity violation. An author with the same details might already exist.");
            return "add-author";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
            return "add-author";
        }
    }

    @GetMapping("/updateAuthor/{id}")
    public String showUpdateAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = libraryService.getAuthorById(id);
        if (author == null) return "redirect:/";
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("author") Author author, Model model) {
        try {
            libraryService.saveAuthor(author);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Integrity violation. Update failed.");
            return "update-author";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
            return "update-author";
        }
    }

    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Integrity violation.");
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add-book";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add-book";
        }
    }

    @GetMapping("/updateBook/{id}")
    public String showUpdateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = libraryService.getBookById(id);
        if (book == null) return "redirect:/";
        model.addAttribute("book", book);
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "update-book";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Integrity violation. Update failed.");
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "update-book";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "update-book";
        }
    }
}
