package com.devraj.tutorials.simpleSpringBoot.Dao;

import com.devraj.tutorials.simpleSpringBoot.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Annotation Repository means, it is telling Spring that this class is Dao
// i.e responsible for talking to Database for CRUD operation.
@Repository
public class BookDao {

    private static Map<Integer, Book> books;

    // Dummmy Database
    static {
        books = new HashMap<Integer, Book>() {
            {
                put(1, new Book(1, "Deep Work", "Cal Newport"));
                put(2, new Book(2, "Flow", "Mihaly"));
                put(3, new Book(3,  "Barking up wrong tree", "Eric Barker"));
            }
        };
    }

    public static Map<Integer, Book> getBooksMap() {
        return books;
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public Book getBookById(int id) {
        return this.books.get(id);
    }

    public void removeBookById(int id) {
        books.remove(id);
    }

    public void addBook(Book book) {
        // Better auto-increment the id.
        books.put(book.getBookId(), book);
    }

    public void updateBook(Book book) {
        books.put(book.getBookId(), book);
    }
}
