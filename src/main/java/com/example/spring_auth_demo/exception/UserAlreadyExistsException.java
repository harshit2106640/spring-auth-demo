package com.example.spring_auth_demo.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
