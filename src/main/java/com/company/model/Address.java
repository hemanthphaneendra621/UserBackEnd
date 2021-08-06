package com.company.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * creating getters and setters for address.
 */
public abstract class Address {
    /**
     * creating variables for address
     */
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String Country;
    private String postalCode;

    /**
     * Creating the Address of the users
     * @param address1 address1 of the users
     * @param address2 address2 of the users
     * @param city city of the users
     * @param state state of the users
     * @param Country country of the users
     * @param postalCode postal code of the users
     */
    public Address(String address1,String address2,String city,String state,String Country,String postalCode){
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.Country = Country;
        this.postalCode = postalCode;
    }
    public Address(){

    }


    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return the address1 of the users
     */

    public String toJsonString(){
        return "{ \"address1\" : \"" + address1 + "\"" +
                ", \"address2\" : \"" + address2 + "\"" +
                ", \"city\" : \"" + city + "\"" +
                ", \"state\" : \"" + state + "\"" +
                ", \"country\" : \"" + Country + "\"" +
                ", \"postalCode\" : " + postalCode + " }";

    }

    /**
     *
     * @return String of address
     */
    @Override
    public String toString() {
        return address1+" "+address2+" "+city+" "+state+" "+Country+" "+postalCode;
    }
}
