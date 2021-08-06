package com.company.util;
import com.mongodb.client.MongoClients;

public class ClientValidation {
    /**
     *
     * @return the mongoClient.
     */
    public com.mongodb.client.MongoClient mongoClient(){
        String uri = "mongodb://localhost:27017";
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }
}
