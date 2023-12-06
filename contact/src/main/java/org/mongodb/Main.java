package org.mongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> coll;

    public Main() {
        // Creating a MongoClient
        mongoClient = MongoClients.create("mongodb+srv://Fondasa:bobodawgs@cluster0.vuf0wnq.mongodb.net/?retryWrites=true&w=majority");

        // Getting a reference to the database
        database = mongoClient.getDatabase("contactDB");

        // Getting a reference to the collection
        coll = database.getCollection("contactCollection");

        // Printing the name of the database
        System.out.println("Connected to database: " + database.getName());
    }

    public void createDocument(Document newDocument) {
        coll.insertOne(newDocument);
        System.out.println("Document di Insert telah Sukses!");
    }

    public Document readDocument(String key, Object value) {
        return coll.find(new Document(key, value)).first();
    }

    public void updateDocument(String updateKey, Object updateValue, Document updatedDocument) {
        coll.updateOne(new Document(updateKey, updateValue), new Document("$set", updatedDocument));
        System.out.println("Document updated telah Sukses!");
    }

    public void deleteDocument(String deleteKey, Object deleteValue) {
        coll.deleteOne(new Document(deleteKey, deleteValue));
        System.out.println("Document dihapus telah Sukses!");
    }

    public static void main(String[] args) {
//        // Creating a MongoClient
//        MongoClient mongoClient = MongoClients.create("mongodb+srv://Fondasa:bobodawgs@cluster0.vuf0wnq.mongodb.net/?retryWrites=true&w=majority");
//
//        // Getting a reference to the database
//        MongoDatabase database = mongoClient.getDatabase("contactDB");
//
//        MongoCollection coll = database.getCollection("contactCollection");
//
//        // Printing the name of the database
//        System.out.println("Connected to database: " + database.getName());
//
//        Document doc = new Document("id", "1")
//                .append("nama","fondasa")
//                .append("email", "fondasa@gmail.com")
//                .append("notelp", "08912345612")
//                .append("kelamin","perempuan");
//
//        coll.insertOne(doc);
//
//
//
//        // Closing the connection to MongoDB
//        mongoClient.close();
//
    }

}