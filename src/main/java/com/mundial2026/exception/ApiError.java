package com.mundial2026.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

    //Errores que se le mandan al cliente
    private int codigo;
    private String mensaje;
    private LocalDateTime timeStamp;
    
}
