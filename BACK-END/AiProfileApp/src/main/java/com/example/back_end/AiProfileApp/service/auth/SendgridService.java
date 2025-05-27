package com.example.back_end.AiProfileApp.service.auth;

import com.example.back_end.AiProfileApp.dto.auth.SendVerificationCodeDTO;
import com.example.back_end.AiProfileApp.dto.auth.ValidateVerificationCodeDTO;

import java.io.IOException;

public interface SendgridService {
    void sendVerificationEmail(SendVerificationCodeDTO sendVerificationCodeDTO, boolean isRegistration);

    boolean validateVerificationCode(ValidateVerificationCodeDTO validateVerificationCodeDTO);
}
