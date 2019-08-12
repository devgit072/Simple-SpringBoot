package com.devraj.tutorials.simpleSpringBoot.Dao;

import com.devraj.tutorials.simpleSpringBoot.Entity.Book;

import java.util.Collection;
import java.util.Map;

public interface BookDao {

    public Collection<Book> getAllBooks();

    public Book getBookById(int id);

    public void removeBookById(int id);

    public void addBook(Book book);

    public void updateBook(Book book);
}
