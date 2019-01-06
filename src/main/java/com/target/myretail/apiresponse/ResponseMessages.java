package com.target.myretail.apiresponse;

/*
 * ResponseMessages interface has all the response messages for different request scenarios.
 */
public interface ResponseMessages {

	//-ve
    String PRODUCT_ID_NULL_MESSAGE = "PRODUCT Id Cannot be null";
    String PRODUCT_OR_CP_NAME_NULL_MESSAGE = "PRODUCT Id or Current Price Cannot be null";
    String OBJECT_CANNOT_BE_NULL = "The object cannot be null";
    String PRODUCT_NOT_FOUND = "Requested PRODUCT not found";
    String CP_NOT_FOUND_FOR_PRODUCT = "Current Price not found for the PRODUCT";
    String PRODUCTS_NOT_AVAILABLE = "No PRODUCTS";
    //+ve
    String SAVE_SUCCESS = "Product saved successfully";
    String UPDATE_SUCCESS = "Product updated successfully";
    String DELETE_SUCCESS = "Product deleted successfully";

}
