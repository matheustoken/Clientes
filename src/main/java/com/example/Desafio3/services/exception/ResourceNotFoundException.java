package com.example.Desafio3.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }

}
