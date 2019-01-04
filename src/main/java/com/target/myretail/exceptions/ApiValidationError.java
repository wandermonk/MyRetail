package com.target.myretail.exceptions;

public class ApiValidationError extends ApiSubError {

    private Object rejectedValue;
    private String message;
    private String field;
    private String object;

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.message = message;
        this.rejectedValue = rejectedValue;
        this.field = field;
    }

    public ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;

    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
