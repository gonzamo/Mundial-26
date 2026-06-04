package com.mundial2026.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    //Excepción personalizada cuando no se encuentre algo
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
