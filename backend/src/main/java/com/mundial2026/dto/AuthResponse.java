package com.mundial2026.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//Esta clase envia información al usuario
@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
}