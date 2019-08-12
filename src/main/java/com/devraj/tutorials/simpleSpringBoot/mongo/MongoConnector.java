package com.devraj.tutorials.simpleSpringBoot.mongo;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/*
Basic Mongo DB commands:
Create new Database: use DBName
Create new colelction: db.createCollection("Books")
 */
public class MongoConnector {
    private final String MONGO_ENDPOINT = "localhost";
    private final int MONGO_PORT = 27017; // DEFAULT MongoDB PORT.
    private MongoClient client;

    public MongoConnector() {
        initMongoDBClient();
    }
    private void initMongoDBClient() {
        this.client = new MongoClient(MONGO_ENDPOINT, MONGO_PORT);
    }

    public MongoDatabase getMongoDatabase() {
        return client.getDatabase("SPRINGBOOT_TUT");
    }

    public static void main(String[] args) {
        MongoConnector mongoConnector = new MongoConnector();
        MongoDatabase db = mongoConnector.getMongoDatabase();
    }
}
