package com.devraj.tutorials.simpleSpringBoot.Service;

import com.devraj.tutorials.simpleSpringBoot.Dao.BookDao;
import com.devraj.tutorials.simpleSpringBoot.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

// Tell Spring that this class is in service layer.
@Service
public class BookService {

    @Autowired
    @Qualifier("DummyData")
    // BookDao has many implementation. Tell Spring which one to pick.
    private BookDao bookDao;

    public Collection<Book> getBooks() {
        return this.bookDao.getAllBooks();
    }

    public Book getBookById(int id) {
        return this.bookDao.getBookById(id);
    }

    public void removeBokById(int id) {
        this.bookDao.removeBookById(id);
    }

    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }
}
