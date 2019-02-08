package com.example.exeption;

/**
 * Created by ayhanugurlu on 2/8/19.
 */
public abstract  class BaseException extends Exception  {

    private  String errorMessage;

    public BaseException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
