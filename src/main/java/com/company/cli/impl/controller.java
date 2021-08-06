package com.company.cli.impl;

import com.company.model.users;
import com.company.service.UserService;
import com.company.service.impl.UserServices;
import com.company.util.ClientValidation;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.UUID;

@Path("users")
public class controller extends ClientValidation implements com.company.cli.UserCli{
    UserService UserServices = new UserServices();

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("emailAddress") String email, @QueryParam("password") String password){
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        System.out.println(password+"pass");
        System.out.println(email);
        String userString = UserServices.getUserObject(email,password);
        if(userString.equals("No Such users Found!!!")){
            return Response.noContent()
                    .status(Response.Status.NO_CONTENT)
                    .build();
        }
        else {
            JSONObject userObj = new JSONObject(userString);
            JSONObject addressObj = new JSONObject(userObj.get("Address").toString());
            users user = new users(userObj.get("Uuid").toString(), userObj.get("FirstName").toString(), userObj.get("LastName").toString(),
                    userObj.get("EmailAddress").toString(), userObj.get("PhoneNumber").toString(), userObj.get("Password").toString(),
                    addressObj.get("address1").toString(), addressObj.get("address2").toString(), addressObj.get("city").toString(),
                    addressObj.get("state").toString(), addressObj.get("country").toString(), addressObj.get("postalCode").toString());
            return Response.ok(user)
                    .status(Response.Status.OK)
                    .build();
        }
    }

    @GET
    @Path("email")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithEmail(@QueryParam("emailAddress") String email){
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        System.out.println(email+"userEmail");
        String userString = UserServices.getUserObjectWithEmail(email);
        if(userString.equals("No Such users Found!!!")){
            return Response.noContent()
                    .status(Response.Status.NO_CONTENT)
                    .build();
        }
        else {
            JSONObject userObj = new JSONObject(userString);
            JSONObject addressObj = new JSONObject(userObj.get("Address").toString());
            users user = new users(userObj.get("Uuid").toString(), userObj.get("FirstName").toString(), userObj.get("LastName").toString(),
                    userObj.get("EmailAddress").toString(), userObj.get("PhoneNumber").toString(), userObj.get("Password").toString(),
                    addressObj.get("address1").toString(), addressObj.get("address2").toString(), addressObj.get("city").toString(),
                    addressObj.get("state").toString(), addressObj.get("country").toString(), addressObj.get("postalCode").toString());
            return Response.ok(user)
                    .status(Response.Status.OK)
                    .build();
        }
    }

    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Document> getProducts(){
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        ArrayList<Document> allProducts = UserServices.getProducts();
        System.out.println(allProducts);
        return allProducts;
    }


    @POST
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(users user){
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        System.out.println("hai");
        System.out.println(user.getPassword()+"first");
        user.setUuid(UUID.randomUUID().toString());
        System.out.println(user.toJsonString());
        UserServices.createUserObject(user);
        return Response.ok(user)
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@QueryParam("emailAddress") String email, @QueryParam("password") String password , users user){
//        System.out.println(id+"id");
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        System.out.println(user+"user");
//        user.setUuid(UUID.randomUUID().toString());
        UserServices.updateUserObject(email,password,user);
        return Response.ok(user)
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("password")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassword(@QueryParam("emailAddress") String email ,users user){
        Logger.getLogger("org.mongodb.driver").setLevel(org.apache.log4j.Level.WARN);
        UserServices.updatePassword(email,user);
        return Response.ok(user)
                .status(Response.Status.OK)
                .build();
    }
}
