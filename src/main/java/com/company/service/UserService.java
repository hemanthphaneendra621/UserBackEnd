package com.company.service;

import com.company.model.users;
import org.bson.Document;

import java.util.ArrayList;

public interface UserService {
    void createUserObject(users user);
    String deleteUserObject(String id);
    void updateUserObject(String email,String password,users user);
    void updatePassword(String email , users user);
    String getUserObject(String id,String password);
    String getUserObjectWithEmail(String email);
    ArrayList<Document> getProducts();
}
