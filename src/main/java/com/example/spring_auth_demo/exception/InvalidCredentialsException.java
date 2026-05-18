package com.example.spring_auth_demo.exception;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(String message){
        super(message);
    }
}
