package com.devraj.tutorials.simpleSpringBoot.Controller;

import com.devraj.tutorials.simpleSpringBoot.Entity.Book;
import com.devraj.tutorials.simpleSpringBoot.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// Tell Spring that this class is in Presentation Layer.
@RestController
@RequestMapping("/books")
public class BookController {

    // Without @Autowired used below , you will have to use BookService book = new BookService();
    // Spring is doing dependency injection for us.
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }

    // It means GET request with api path: /book/{id} path will call this method.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    // It means thet DELETE request with api path: /book/{id} will call this method.
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") int id) {
        bookService.removeBokById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }
}
