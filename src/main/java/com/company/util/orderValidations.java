package com.company.util;

/**
 * validations for order object
 */
public class orderValidations {
    /**
     *
     * @param id id provided by the user.
     * @return true if id length is not 36.
     */
    public static boolean UuidValidation(String id){
        return id.length() != 36;
    }
}
