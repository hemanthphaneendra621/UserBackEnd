package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.dao.impl.UserDaoimpl;
import com.company.model.users;
import com.company.service.UserService;
import org.bson.Document;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * service methods of the user.
 */
public class UserServices implements UserService {
    /**
     * creating a user object and adding it to the database.
     */
    public void createUserObject(users user) {
        UserDao UserDao = new UserDaoimpl();
        JSONObject jsonObject = new JSONObject();
        JSONObject addressJsonObject = new JSONObject();
        addressJsonObject.put("address1",user.getAddress1());
        addressJsonObject.put("address2",user.getAddress2());
        addressJsonObject.put("city",user.getCity());
        addressJsonObject.put("state",user.getState());
        addressJsonObject.put("country",user.getCountry());
        addressJsonObject.put("postalCode",user.getPostalCode());
        jsonObject.put("Uuid", user.getUuid());
        jsonObject.put("FirstName", user.getFirstName());
        jsonObject.put("LastName", user.getLastName());
        jsonObject.put("EmailAddress", user.getEmailAddress());
        jsonObject.put("PhoneNumber", user.getPhoneNumber());
        jsonObject.put("Password",user.getPassword());
        jsonObject.put("Address", addressJsonObject);
        UserDao.addUser(jsonObject);
    }
    /**
     *
     * @param id id provided by the user
     * deleting the user object
     */
    public String deleteUserObject(String id) {
        UserDao UserDao = new UserDaoimpl();
        String deleteUser = UserDao.deleteUser(id);
        return deleteUser;
    }

    /**
     * updating the user.
     */
    public void updateUserObject(String email,String password,users user) {
        UserDao UserDao = new UserDaoimpl();
        UserDao.updateUser(email,password,user);
    }

    public void updatePassword(String email , users user){
        UserDao UserDao = new UserDaoimpl();
        UserDao.updatePassword(email,user);
    }

    /**
     * retrieving the user
     */
    public String getUserObject(String email,String password) {
        UserDao UserDao = new UserDaoimpl();
        String users = UserDao.getUser(email,password);
        return users;
    }

    public String getUserObjectWithEmail(String email) {
        UserDao UserDao = new UserDaoimpl();
        String users = UserDao.getUserWithEmail(email);
        return users;
    }

    public ArrayList<Document> getProducts(){
        UserDao UserDao = new UserDaoimpl();
        return UserDao.getProducts();
    }
}
