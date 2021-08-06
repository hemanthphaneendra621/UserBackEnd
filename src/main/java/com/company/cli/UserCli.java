package com.company.cli;

import com.company.model.users;
import org.bson.Document;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public interface UserCli {
    Response getUser(@QueryParam("emailAddress") String email, @QueryParam("password") String password);
    Response getUserWithEmail(@QueryParam("emailAddress") String email);
    ArrayList<Document> getProducts();
    Response createUser(users user);
    Response updateUser(@QueryParam("emailAddress") String email, @QueryParam("password") String password , users user);
    Response updatePassword(@QueryParam("emailAddress") String email ,users user);
}
