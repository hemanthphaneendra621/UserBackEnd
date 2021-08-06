package com.company.dao.impl;

import com.company.model.users;
import com.company.util.ClientValidation;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * adding , updating the user object to the database
 * retrieving and deleting user object from the database
 */
public class UserDaoimpl extends ClientValidation implements com.company.dao.UserDao {
    /**
     * getting the collection called users from the OrderProject database.
     * @return the collection.
     */
    public MongoCollection<Document> userCollection(){
        MongoClient mongoClient = mongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderProject");
        return mongoDatabase.getCollection("users");
    }

    public MongoCollection<Document> productCollection(){
        MongoClient mongoClient = mongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderProject");
        return mongoDatabase.getCollection("products");
    }
    /**
     * adding the user to the database
     * @param jsonObject the user object
     */
    public void addUser(JSONObject jsonObject) {
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        Document doc =  Document.parse(String.valueOf(jsonObject));
        collection.insertOne(doc);
        mongoClient.close();
    }

    /**
     * deleting the user from the database if an id of the user in database matches id provided by the user.
     * @param id id given by the user
     */
    public String deleteUser(String id) {
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        BasicDBObject deleteUser = new BasicDBObject("Uuid",id);
        int count = (int) collection.deleteOne(deleteUser).getDeletedCount();
        collection.deleteOne(deleteUser);
        mongoClient.close();
        if(count>0){
            return "users Deleted!!!";
        }
        else{
            return "No Such users Found!!!";
        }

    }
    /**
     * retrieving the user from the database if an id of the user in database matches id provided by the user.
     */
    public String getUser(String email, String password){
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        Logger mongoLogger = Logger.getLogger( "com.mongodb" ); mongoLogger.setLevel(Level.SEVERE);
        Document user = collection.find(new Document("EmailAddress",email).append("Password",password)).first();
        mongoClient.close();
        if(user == null){
            return "No Such users Found!!!";
        }
        else {
            return user.toJson();
        }
    }

    public String getUserWithEmail(String email){
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        Logger mongoLogger = Logger.getLogger( "com.mongodb" ); mongoLogger.setLevel(Level.SEVERE);
        Document user = collection.find(new Document("EmailAddress",email)).first();
        mongoClient.close();
        if(user == null){
            return "No Such users Found!!!";
        }
        else {
            return user.toJson();
        }
    }
    /**
     * updating the user in the database if an id of the user in database matches id provided by the user.
     */
    public void updateUser(String email,String password,users user){
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        BasicDBObject newUser = new BasicDBObject();
        newUser.append("$set",new BasicDBObject().append("FirstName", user.getFirstName())
                                                      .append("LastName",user.getLastName())
                                                      .append("EmailAddress",user.getEmailAddress())
                                                       .append("PhoneNumber",user.getPhoneNumber())
                                                       .append("Password",user.getPassword())
                .append("Address.address1", user.getAddress1())
                .append("Address.address2", user.getAddress2())
                .append("Address.city", user.getCity())
                .append("Address.state", user.getState())
                .append("Address.country", user.getCountry())
                .append("Address.postalCode", user.getPostalCode())

        );
        BasicDBObject oldUser = new BasicDBObject().append("EmailAddress", email).append("Password",password);
        collection.updateOne(oldUser, newUser);

        mongoClient.close();
    }

    public void updatePassword(String email , users user){
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> collection = userCollection();
        BasicDBObject newUser = new BasicDBObject();
        newUser.append("$set",new BasicDBObject().append("FirstName", user.getFirstName())
                .append("LastName",user.getLastName())
                .append("EmailAddress",user.getEmailAddress())
                .append("PhoneNumber",user.getPhoneNumber())
                .append("Password",user.getPassword())
                .append("Address.address1", user.getAddress1())
                .append("Address.address2", user.getAddress2())
                .append("Address.city", user.getCity())
                .append("Address.state", user.getState())
                .append("Address.country", user.getCountry())
                .append("Address.postalCode", user.getPostalCode())

        );
        BasicDBObject oldUser = new BasicDBObject().append("EmailAddress", email);
        collection.updateOne(oldUser, newUser);

        mongoClient.close();
    }

    public ArrayList<Document> getProducts(){
        MongoClient mongoClient = mongoClient();
        MongoCollection<Document> productCollection = productCollection();
        FindIterable<Document> allProducts = productCollection.find();
        ArrayList<Document> products = new ArrayList<>();
        for (Document allProduct : allProducts) {
            products.add(allProduct);
        }
        mongoClient.close();
        return products;
    }
}
