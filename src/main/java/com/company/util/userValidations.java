package com.company.util;
/**
 * validations for user object
 */
public class userValidations {
    /**
     *
     * @param firstName name of the user
     * @return true if name is empty or less than 3 characters or does not match the required format.
     */
    public static boolean firstNameValidation(String firstName){
        return firstName.isEmpty() || firstName.length() < 3 || !firstName.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param lastName name of the user
     * @return true if name is empty or less than 3 characters or does not match the required format.
     */
    public static boolean lastNameValidation(String lastName){
        return lastName.isEmpty() || lastName.length() < 3 || !lastName.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param email email of the user
     * @return true if email is empty or does not match the required format.
     */
    public static boolean emailValidation(String email){
        return email.isEmpty() || !email.matches("^(.+)@(.+)$");
    }

    /**
     *
     * @param phoneNumber phone number of the user
     * @return true if number is empty or length not equal to 10 or does not match the required format.
     */
    public static boolean phoneNumberValidation(String phoneNumber){
        return phoneNumber.length() != 10 || !phoneNumber.matches("^[0-9]*$");
    }
    /**
     *
     * @param address1 address1 of the user
     * @return true if address1 is empty or less than 3 characters or does not match the required format.
     */
    public static boolean address1Validation(String address1){
        return address1.isEmpty() || address1.length() < 3 || !address1.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param address2 address2 of the user
     * @return true if address2 is empty or less than 3 characters or does not match the required format.
     */
    public static boolean address2Validation(String address2){
        return address2.isEmpty() || address2.length() < 3 || !address2.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param city city of the user
     * @return true if city is empty or less than 3 characters or does not match the required format.
     */
    public static boolean cityValidation(String city){
        return city.isEmpty() || city.length() < 3 || !city.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param state state of the user
     * @return true if state is empty or less than 3 characters or does not match the required format.
     */
    public static boolean stateValidation(String state){
        return state.isEmpty() || state.length() < 3 || !state.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param country country of the user
     * @return true if country is empty or less than 3 characters or does not match the required format.
     */
    public static boolean countryValidation(String country){
        return country.isEmpty() || country.length() < 3 || !country.matches("^[a-zA-Z]*$");
    }
    /**
     *
     * @param postalCode zip code of the user
     * @return true if zip code is empty or length not equal to 5 or does not match the required format.
     */
    public static boolean postalCodeValidation(String postalCode){
        return postalCode.length() != 5 || !postalCode.matches("^[0-9]*$");
    }

    /**
     *
     * @param id id provided by the user
     * @return true if id length is not equal to 36.
     */
    public static boolean UuidValidation(String id){
        return id.length() != 36;
    }
}
