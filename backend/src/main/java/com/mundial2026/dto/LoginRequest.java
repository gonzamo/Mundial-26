package com.mundial2026.dto;

import lombok.Data;

//Esta clase recibe la información que el usuario manda hacia tu servidor.
@Data
public class LoginRequest {
    private String username;
    private String password;
}