package com.company.util;

/**
 * validations for product object
 */
public class productValidations {
    /**
     *
     * @param productName name of the product
     * @return true if name is empty or less than 3 characters or does not match the required format.
     */
    public static boolean productNameValidation(String productName){
        return productName.isEmpty() || productName.length() < 3 || !productName.matches("^[a-zA-Z]*$");
    }

    /**
     *
     * @param category category of the product
     * @return true if category is empty or less than 3 characters or does not match the required format.
     */
    public static boolean categoryValidation(String category){
        return category.isEmpty() || category.length() < 3 || !category.matches("^[a-zA-Z]*$");
    }

    /**
     *
     * @param price price of the product.
     * @return true if price is empty or does not match the required format.
     */
    public static boolean priceValidation(String price){
        return price.isEmpty() ||  !price.matches("^[0-9]*$");
    }

    /**
     *
     * @param stock stock of the product
     * @return true if stock is empty or does not match the required format.
     */
    public static boolean stockValidation(String stock){
        return stock.isEmpty() ||  !stock.matches("^[0-9]*$");
    }

    /**
     *
     * @param productManufacturer manufacturer of the product.
     * @return true if manufacturer is empty or less than 3 characters or does not match the required format.
     */
    public static boolean productManufacturerValidation(String productManufacturer){
        return productManufacturer.isEmpty() || productManufacturer.length()<3 || !productManufacturer.matches("^[a-zA-Z]*$");
    }

    /**
     *
     * @param description description of the product.
     * @return true if description is empty or less than 3 characters or does not match the required format.
     */
    public static boolean descriptionValidation(String description){
        return description.isEmpty() || description.length()<3 || !description.matches("^[a-zA-Z]*$");
    }

    /**
     *
     * @param id id provided by the user.
     * @return true if id length is not 36.
     */
    public static boolean UuidValidation(String id){
        return id.length() != 36;
    }
}
