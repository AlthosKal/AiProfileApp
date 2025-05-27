package com.example.back_end.AiProfileApp.service.auth;

import com.example.back_end.AiProfileApp.dto.auth.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    // Metodos para registro e inicio de sesión
    TokenResponseDTO authenticate(String nameOrEmail, String password, HttpServletResponse response);

    void registerUser(NewUserDTO newUserDTO);

    // Métodos de cambio de contraseña
    String changePasswordWithVerification(ChangePasswordDTO changePasswordDTO);

    // Cierre de Sesión
    void logout(String token, HttpServletResponse response);

}
