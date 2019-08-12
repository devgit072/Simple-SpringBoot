package com.devraj.tutorials.simpleSpringBoot.Dao;

import com.devraj.tutorials.simpleSpringBoot.Entity.Book;
import com.devraj.tutorials.simpleSpringBoot.mongo.MongoConnector;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BookDaoMongoDBImpl implements BookDao {
    private MongoDatabase mongoDatabase;
    private MongoCollection bookCollection;
    private final String bookCollectionName = "Books";

    BookDaoMongoDBImpl() {
        MongoConnector connector = new MongoConnector();
        mongoDatabase = connector.getMongoDatabase();
        bookCollection = mongoDatabase.getCollection(bookCollectionName);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public void removeBookById(int id) {

    }

    @Override
    public void addBook(Book book) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("_id", book.getBookId());
        docBuilder.append("bookName", book.getBookName());
        docBuilder.append("authorName", book.getBookName());

        DBObject dbObject = docBuilder.get();
        bookCollection.insertOne(dbObject);
    }

    @Override
    public void updateBook(Book book) {

    }
}
