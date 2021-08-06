package com.company.dao;

import com.company.model.users;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;

public interface UserDao {
    ArrayList<Document> getProducts();

    void addUser(JSONObject jsonObject);
    String deleteUser(String id);
    String getUser(String id,String password);
    String getUserWithEmail(String email);
    void updateUser(String email,String password, users user);
    void updatePassword(String email , users user);
}
