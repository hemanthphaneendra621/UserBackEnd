package com.company.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * creating getters and settres for users
 */
public class users extends Address{
    /**
     * creating variables for users
     */
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String Uuid;
    private String password;


    /**
     * To create a new users by initializing.

     * @param emailAddress email of the users
     * @param phoneNumber Phone Number of the users
     */
    public users(String Uuid,String firstName, String lastName, String emailAddress, String phoneNumber,String password,String address1, String address2, String city, String state, String Country, String postalCode){
        super(address1,address2,city,state,Country,postalCode);
        this.Uuid  =Uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;


    }
//    String address1, String address2, String city, String state, String Country, String postalCode
    public users(){
        super();
    }
    /**
     *
     * @return the Uuid of the users
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
